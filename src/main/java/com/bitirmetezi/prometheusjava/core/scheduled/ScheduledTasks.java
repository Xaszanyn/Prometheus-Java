package com.bitirmetezi.prometheusjava.core.scheduled;

import com.bitirmetezi.prometheusjava.data.dto.UserOfMailGroupDto;
import com.bitirmetezi.prometheusjava.data.entity.AlertMailGroup;
import com.bitirmetezi.prometheusjava.data.entity.User;
import com.bitirmetezi.prometheusjava.data.entity.UserMailGroup;
import com.bitirmetezi.prometheusjava.data.repository.AlertMailGroupRepository;
import com.bitirmetezi.prometheusjava.data.repository.MailListRepository;
import com.bitirmetezi.prometheusjava.data.repository.UserMailGroupRepository;
import com.bitirmetezi.prometheusjava.data.repository.UserRepository;
import com.bitirmetezi.prometheusjava.service.alerthistoryservice.HistoryCreateServiceInput;
import com.bitirmetezi.prometheusjava.service.alerthistoryservice.HistoryService;
import com.bitirmetezi.prometheusjava.service.alertservice.AlertService;
import com.bitirmetezi.prometheusjava.service.alertservice.AlertServiceOutput;
import com.bitirmetezi.prometheusjava.service.mailservice.MailServiceInput;
import com.bitirmetezi.prometheusjava.service.mailservice.PostService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Configuration
@EnableAsync
@EnableScheduling
@RequiredArgsConstructor
public class ScheduledTasks {

    @Autowired
    private final AlertService alertService;
    private final HistoryService historyService;
    private final AlertMailGroupRepository alertMailGroupRepository;
    private final UserMailGroupRepository userMailGroupRepository;
    private final UserRepository userRepository;
    private final MailListRepository mailListRepository;
    private final PostService postService;

    @Async
    @Scheduled(fixedRate = 1000 * 60 * 3)
    public void callService(){
        int time  = LocalTime.now().getHour() * 100 + LocalTime.now().getMinute();
        log.info(Thread.currentThread().getName() + " Prometheus call executed at " + new Date());

        try {
            List<AlertServiceOutput> alertServiceOutputs = alertService.findAllActiveAlerts();
            if (alertServiceOutputs == null || CollectionUtils.isEmpty(alertServiceOutputs)){
                log.error("Could not get alerts!");
                return;
            }

            for(AlertServiceOutput alert : alertServiceOutputs){
                if ((alert.getStartActiveTime() < alert.getEndActiveTime() && alert.getStartActiveTime() <= time && alert.getEndActiveTime() >= time) ||
                        (alert.getStartActiveTime() > alert.getEndActiveTime() && (alert.getStartActiveTime() <= time || alert.getEndActiveTime() >= time))) {
                    String queryWoSpaces = alert.getQuery().replace(" ", "%20");
                    String res = sendPrometheusCall();
                    // parse the value
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode resObj = mapper.readTree(res);
                    log.info(resObj.asText());
                    JsonNode result = resObj.get("data").get("result");
                    if (result.size() == 0)
                        continue;
                    saveHistoryAndSendMailSms(alert, result);
                }
            }
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
    }

    private String sendPrometheusCall(){
        return "{\"status\":\"success\",\"data\":{\"resultType\":\"vector\",\"result\":[{\"metric\":{},\"value\":[1685388586.687,\"2069.914008282388\"]}]}}";
    }

    private void saveHistoryAndSendMailSms(AlertServiceOutput alert, JsonNode result){
        double alertValue = Double.parseDouble(result.get(0).get("value").get(1).textValue());

        Double thresholdValue = (double) alert.getThresholdValue();
        String thresholdSign = alert.getThresholdSign();

        if ((thresholdSign.equals("<") && alertValue < thresholdValue) || (thresholdSign.equals(">") && alertValue > thresholdValue)
                || (thresholdSign.equals("<=") && alertValue <= thresholdValue) || (thresholdSign.equals(">=") && alertValue >= thresholdValue)){
            saveTriggeredAlert(alert.getId(), alertValue);
            sendMail(alert, alertValue);
        }
    }

    private void saveTriggeredAlert(Long alertId, double alertValue){
        log.info("Alert triggered");
        double roundAlertValue = Math.round(alertValue * 100) / 100.0;
        HistoryCreateServiceInput historyCreateServiceInput = HistoryCreateServiceInput.builder()
                .alertId(alertId)
                .alertValue(alertValue)
                .build();
        historyService.saveHistory(historyCreateServiceInput);
    }

    private void sendMail(AlertServiceOutput alert, double alertValue){
        List<AlertMailGroup> alertMailGroups = alertMailGroupRepository.findAlertMailGroupByAlert_Id(alert.getId());
        for (AlertMailGroup alertMailGroup : alertMailGroups){
            List<UserOfMailGroupDto> users = userRepository.findUsersByMailListId(alertMailGroup.getMailList().getId());
            for (UserOfMailGroupDto dto : users){
                MailServiceInput serviceInput = MailServiceInput.builder()
                        .to(dto.getEmail())
                        .subject(alert.getName() + " isimli alarm çalıştı!")
                        .body("Sayın " + dto.getName() + ",\n" + alert.getName() + " adlı alarm " + alertValue + " değeri ile çalışmıştır. Bilginize...")
                        .build();

                postService.sendEmailOnAlert(serviceInput);
            }
        }
    }
}
