package com.bitirmetezi.prometheusjava.service.userservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateServiceInput {
    private String name;
    private String email;
    private String password;
    private String organisation;
    private Boolean isAdmin;
}
