package com.bitirmetezi.prometheusjava.controller.userapi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateRequest {
    private String name;
    private String email;
    private String password;
    private String organisation;
    private Boolean isAdmin;
}
