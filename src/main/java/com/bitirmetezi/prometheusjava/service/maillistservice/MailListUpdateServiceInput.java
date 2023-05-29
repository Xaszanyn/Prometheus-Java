package com.bitirmetezi.prometheusjava.service.maillistservice;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MailListUpdateServiceInput {
    private Long id;
    private String name;
    private Long updateTime;
    private Long lastUpdateUserId;
}
