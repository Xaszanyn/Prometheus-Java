package com.bitirmetezi.prometheusjava.controller.alertcontroller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class AddAlertToMailListRequest {
    private Long alertId;
    private Long mailListId;
    private Long insertUserId;
}
