package com.bitirmetezi.prometheusjava.service.mailservice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MailServiceInput {
    private String to;
    private String subject;
    private String body;
}
