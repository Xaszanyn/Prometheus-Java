package com.bitirmetezi.prometheusjava.core.mappers;

import com.bitirmetezi.prometheusjava.data.dto.AlertHistoryDto;
import com.bitirmetezi.prometheusjava.service.alerthistoryservice.HistoryServiceOutput;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class HistoryMapper {
    public static List<HistoryServiceOutput> map(List<AlertHistoryDto> dtos){
        if (!CollectionUtils.isEmpty(dtos)){
            List<HistoryServiceOutput> outputList = new ArrayList<>();
            for (AlertHistoryDto dto : dtos){
                HistoryServiceOutput serviceOutput = HistoryServiceOutput.builder()
                        .alertId(dto.getId())
                        .alertName(dto.getName())
                        .alertSeverity(dto.getSeverity())
                        .thresholdSign(dto.getThresholdSign())
                        .thresholdValue(dto.getThresholdValue())
                        .alertValue(dto.getAlertValue())
                        .alertTime(DateTimeMapper.map(dto.getAlertTime()))
                        .build();
                outputList.add(serviceOutput);
            }
            return outputList;
        }
        return new ArrayList<>();
    }
}
