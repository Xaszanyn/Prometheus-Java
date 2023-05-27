package com.bitirmetezi.prometheusjava.service.alertservice;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AlertCreateServiceInput {
    private String name;
    private String query;
    private Long insertUserId;
    private Long insertTime;
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
