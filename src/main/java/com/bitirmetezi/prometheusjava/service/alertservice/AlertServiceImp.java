package com.bitirmetezi.prometheusjava.service.alertservice;

import com.bitirmetezi.prometheusjava.data.entity.Alert;
import com.bitirmetezi.prometheusjava.data.entity.AlertMailGroup;
import com.bitirmetezi.prometheusjava.data.entity.MailList;
import com.bitirmetezi.prometheusjava.data.repository.AlertMailGroupRepository;
import com.bitirmetezi.prometheusjava.data.repository.AlertRepository;
import com.bitirmetezi.prometheusjava.data.repository.MailListRepository;
import com.bitirmetezi.prometheusjava.data.util.AlertMailGroupId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.bitirmetezi.prometheusjava.core.mappers.AlertMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlertServiceImp implements AlertService{

    @Autowired
    private final AlertRepository alertRepository;
    private final MailListRepository mailListRepository;
    private final AlertMailGroupRepository alertMailGroupRepository;
    @Override
    public List<AlertServiceOutput> findAll() {
        List<Alert> outputList = alertRepository.findAll();

        if (CollectionUtils.isEmpty(outputList)){
            log.error("Can't find any data.");
            return new ArrayList<>();
        }
        List<AlertServiceOutput> serviceOutputs = map(outputList);
        for(AlertServiceOutput serviceOutput : serviceOutputs){
            serviceOutput.setMailLists(mailListRepository.findMailListsByAlertId(serviceOutput.getId()));
        }
        return serviceOutputs;
    }

    @Override
    public AlertServiceOutput findById(Long id) {
        AlertServiceOutput serviceOutput = map(alertRepository.findById(id));
        serviceOutput.setMailLists(mailListRepository.findMailListsByAlertId(serviceOutput.getId()));
        return serviceOutput;
    }

    @Override
    public String saveAlert(AlertCreateServiceInput input) {
        alertRepository.save(map(input));
        return "success";
    }

    @Override
    public String updateAlert(AlertUpdateServiceInput input) {
        if (alertRepository.existsById(input.getId())){
            Alert alert = alertRepository.findById(input.getId()).get();
            Alert newAlert = map(input);
            newAlert.setInsertUserId(alert.getInsertUserId());
            newAlert.setInsertTime(alert.getInsertTime());
            alertRepository.save(map(input));
            return "success";
        }
        return "not found";
    }

    @Override
    public String deleteAlert(Long id) {
        if (alertRepository.existsById(id)){
            alertRepository.deleteById(id);
            return "success";
        }
        return "not found";
    }

    @Override
    public String addAlertToMailList(AddAlertToMailListServiceInput input) {
        Optional<Alert> optionalAlert = alertRepository.findById(input.getAlertId());
        Optional<MailList> optionalMailList = mailListRepository.findById(input.getMailListId());
        if (optionalMailList.isPresent() && optionalAlert.isPresent()){
            Alert alert = optionalAlert.get();
            MailList mailList = optionalMailList.get();

            AlertMailGroup alertMailGroup = new AlertMailGroup(AlertMailGroupId.builder().alertId(input.getAlertId()).mailListId(input.getMailListId()).build(),
                    LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(3)),
                    LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(3)),
                    input.getInsertUserId(), alert, mailList);

            alertMailGroupRepository.save(alertMailGroup);
            return "success";
        }
        return "alert or mail list does not exist or not found.";
    }

    @Override
    public String deleteAlertFromMailList(Long alertId, Long mailListId) {
        if (alertRepository.existsById(alertId) && mailListRepository.existsById(mailListId)){
            alertMailGroupRepository.deleteById(AlertMailGroupId.builder().alertId(alertId).mailListId(mailListId).build());
            return "success";
        }
        return "not found";
    }
}
