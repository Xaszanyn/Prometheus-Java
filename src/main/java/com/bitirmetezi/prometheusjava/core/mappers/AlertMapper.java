package com.bitirmetezi.prometheusjava.core.mappers;

import com.bitirmetezi.prometheusjava.controller.alertcontroller.AlertCreateRequest;
import com.bitirmetezi.prometheusjava.controller.alertcontroller.AlertUpdateRequest;
import com.bitirmetezi.prometheusjava.data.entity.Alert;
import com.bitirmetezi.prometheusjava.service.alertservice.AlertCreateServiceInput;
import com.bitirmetezi.prometheusjava.service.alertservice.AlertServiceOutput;
import com.bitirmetezi.prometheusjava.service.alertservice.AlertUpdateServiceInput;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AlertMapper {
    public static List<AlertServiceOutput> map(List<Alert> alerts){
        List<AlertServiceOutput> outputList = new ArrayList<>();
        for (Alert alert : alerts){
            AlertServiceOutput serviceOutput = AlertServiceOutput.builder()
                    .id(alert.getId())
                    .name(alert.getName())
                    .query(alert.getQuery())
                    .insertUserId(alert.getInsertUserId())
                    .insertTime(DateTimeMapper.map(alert.getInsertTime()))
                    .updateTime(DateTimeMapper.map(alert.getUpdateTime()))
                    .isActive(alert.getIsActive())
                    .severity(alert.getSeverity())
                    .thresholdSign(alert.getThresholdSign())
                    .thresholdValue(alert.getThresholdValue())
                    .timeInterval(alert.getTimeInterval())
                    .timeValue(alert.getTimeValue())
                    .startActiveTime(alert.getStartActiveTime())
                    .endActiveTime(alert.getEndActiveTime())
                    .build();
            outputList.add(serviceOutput);
        }
        return outputList;
    }

    public static AlertServiceOutput map(Optional<Alert> optionalAlert){
        if (optionalAlert.isPresent()){
            Alert alert = optionalAlert.get();
            return AlertServiceOutput.builder()
                    .id(alert.getId())
                    .name(alert.getName())
                    .query(alert.getQuery())
                    .insertUserId(alert.getInsertUserId())
                    .insertTime(DateTimeMapper.map(alert.getInsertTime()))
                    .updateTime(DateTimeMapper.map(alert.getUpdateTime()))
                    .isActive(alert.getIsActive())
                    .severity(alert.getSeverity())
                    .thresholdSign(alert.getThresholdSign())
                    .thresholdValue(alert.getThresholdValue())
                    .timeInterval(alert.getTimeInterval())
                    .timeValue(alert.getTimeValue())
                    .startActiveTime(alert.getStartActiveTime())
                    .endActiveTime(alert.getEndActiveTime())
                    .build();
        }
        return null;
    }

    public static Alert map(AlertCreateServiceInput serviceInput){
        return Alert.builder()
                .name(serviceInput.getName())
                .query(serviceInput.getQuery())
                .insertUserId(serviceInput.getInsertUserId())
                .insertTime(serviceInput.getInsertTime())
                .updateTime(serviceInput.getUpdateTime())
                .isActive(serviceInput.getIsActive())
                .severity(serviceInput.getSeverity())
                .thresholdSign(serviceInput.getThresholdSign())
                .thresholdValue(serviceInput.getThresholdValue())
                .timeInterval(serviceInput.getTimeInterval())
                .timeValue(serviceInput.getTimeValue())
                .startActiveTime(serviceInput.getStartActiveTime())
                .endActiveTime(serviceInput.getEndActiveTime())
                .build();
    }

    public static Alert map(AlertUpdateServiceInput serviceInput){
        return Alert.builder()
                .id(serviceInput.getId())
                .name(serviceInput.getName())
                .query(serviceInput.getQuery())
                .insertUserId(1L)
                .insertTime(serviceInput.getUpdateTime())
                .updateTime(serviceInput.getUpdateTime())
                .isActive(serviceInput.getIsActive())
                .severity(serviceInput.getSeverity())
                .thresholdSign(serviceInput.getThresholdSign())
                .thresholdValue(serviceInput.getThresholdValue())
                .timeInterval(serviceInput.getTimeInterval())
                .timeValue(serviceInput.getTimeValue())
                .startActiveTime(serviceInput.getStartActiveTime())
                .endActiveTime(serviceInput.getEndActiveTime())
                .build();
    }

    public static AlertCreateServiceInput map(AlertCreateRequest request){
        return AlertCreateServiceInput.builder()
                .name(request.getName())
                .query(request.getQuery())
                .insertUserId(request.getInsertUserId())
                .insertTime(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(3)))
                .updateTime(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(3)))
                .isActive(request.getIsActive())
                .severity(request.getSeverity())
                .thresholdSign(request.getThresholdSign())
                .thresholdValue(request.getThresholdValue())
                .timeInterval(request.getTimeInterval())
                .timeValue(request.getTimeValue())
                .startActiveTime(request.getStartActiveTime())
                .endActiveTime(request.getEndActiveTime())
                .build();
    }

    public static AlertUpdateServiceInput map(AlertUpdateRequest request){
        return AlertUpdateServiceInput.builder()
                .id(request.getId())
                .name(request.getName())
                .query(request.getQuery())
                .updateTime(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(3)))
                .isActive(request.getIsActive())
                .severity(request.getSeverity())
                .thresholdSign(request.getThresholdSign())
                .thresholdValue(request.getThresholdValue())
                .timeInterval(request.getTimeInterval())
                .timeValue(request.getTimeValue())
                .startActiveTime(request.getStartActiveTime())
                .endActiveTime(request.getEndActiveTime())
                .build();
    }
}
