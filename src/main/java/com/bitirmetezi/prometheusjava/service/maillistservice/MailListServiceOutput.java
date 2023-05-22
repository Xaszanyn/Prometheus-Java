package com.bitirmetezi.prometheusjava.service.maillistservice;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class MailListServiceOutput {
    private Long id;
    private String name;
    private Long insertTime;
    private Long updateTime;
    private Long insertUserId;
    private Long lastUpdateUserId;
}
