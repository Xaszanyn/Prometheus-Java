package com.bitirmetezi.prometheusjava.controller.maillistcontroller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MailListCreateRequest {
    private String name;
    private Long insertUserId;
    private Long lastUpdateUserId;
}
