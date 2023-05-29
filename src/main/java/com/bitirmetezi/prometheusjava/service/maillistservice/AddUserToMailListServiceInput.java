package com.bitirmetezi.prometheusjava.service.maillistservice;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddUserToMailListServiceInput {
    private Long userId;
    private Long MailListId;
    private Long insertUserId;
}
