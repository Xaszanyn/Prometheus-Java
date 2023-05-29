package com.bitirmetezi.prometheusjava.service.alertservice;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AlertUpdateServiceInput {
    private Long id;
    private String name;
    private String query;
    private Long updateTime;
    private Boolean isActive;
    private String severity;
    private String thresholdSign;
    private Integer thresholdValue;
    private Integer timeInterval;
    private Character timeValue;
    private Long startActiveTime;
    private Long endActiveTime;
}
