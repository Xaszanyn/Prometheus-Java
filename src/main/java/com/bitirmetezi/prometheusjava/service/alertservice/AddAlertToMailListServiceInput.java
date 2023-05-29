package com.bitirmetezi.prometheusjava.service.alertservice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class AddAlertToMailListServiceInput {
    private Long alertId;
    private Long mailListId;
    private Long insertUserId;
}
