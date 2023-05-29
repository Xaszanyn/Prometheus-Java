package com.bitirmetezi.prometheusjava.service.maillistservice;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class MailListCreateServiceInput {
    private String name;
    private Long insertTime;
    private Long updateTime;
    private Long insertUserId;
    private Long lastUpdateUserId;
}
