package com.bitirmetezi.prometheusjava.controller.alertcontroller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AlertUpdateRequest {
    private Long id;
    private String name;
    private String query;
    private Boolean isActive;
    private String severity;
    private String thresholdSign;
    private Integer thresholdValue;
    private Integer timeInterval;
    private Character timeValue;
    private Long startActiveTime;
    private Long endActiveTime;
}
