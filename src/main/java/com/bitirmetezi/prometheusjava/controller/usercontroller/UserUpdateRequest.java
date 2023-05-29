package com.bitirmetezi.prometheusjava.controller.usercontroller;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserUpdateRequest {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String organisation;
    private Boolean isAdmin;
}
