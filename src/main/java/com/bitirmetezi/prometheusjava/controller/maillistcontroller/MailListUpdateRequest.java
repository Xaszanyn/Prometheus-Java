package com.bitirmetezi.prometheusjava.controller.maillistcontroller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MailListUpdateRequest {
    private Long id;
    private String name;
    private Long lastUpdateUserId;
}
