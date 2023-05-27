package com.bitirmetezi.prometheusjava.service.alerthistoryservice;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HistoryServiceOutput {
    private Long alertId;
    private String alertName;
    private String alertSeverity;
    private String thresholdSign;
    private Integer thresholdValue;
    private Double alertValue;
    private Long alertTime;
}
