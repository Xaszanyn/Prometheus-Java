package com.bitirmetezi.prometheusjava.service.maillistservice;

import com.bitirmetezi.prometheusjava.data.dto.UserOfMailGroupDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Builder
@Getter
@Setter
public class MailListServiceOutput {
    private Long id;
    private String name;
    private String insertTime;
    private String updateTime;
    private Long insertUserId;
    private Long lastUpdateUserId;
    private List<UserOfMailGroupDto> users;
}
