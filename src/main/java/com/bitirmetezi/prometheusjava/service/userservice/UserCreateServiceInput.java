package com.bitirmetezi.prometheusjava.service.userservice;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCreateServiceInput {
    private String name;
    private String email;
    private String password;
    private String organisation;
    private Boolean isAdmin;
}
