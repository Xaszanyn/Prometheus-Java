package com.bitirmetezi.prometheusjava.controller.maillistcontroller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddUserToMailListRequest {
    private Long userId;
    private Long insertUserId;
    private Long mailListId;
}
