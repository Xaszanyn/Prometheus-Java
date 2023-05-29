package com.bitirmetezi.prometheusjava.service.alertservice;

import com.bitirmetezi.prometheusjava.data.dto.MailGroupsOfAlertDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Builder
@Getter
@Setter
public class AlertServiceOutput {
    private Long id;
    private String name;
    private String query;
    private Long insertUserId;
    private String insertTime;
    private String updateTime;
    private Boolean isActive;
    private String severity;
    private String thresholdSign;
    private Integer thresholdValue;
    private Integer timeInterval;
    private Character timeValue;
    private Long startActiveTime;
    private Long endActiveTime;
    private List<MailGroupsOfAlertDto> mailLists;
}
