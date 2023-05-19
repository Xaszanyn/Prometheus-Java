package com.bitirmetezi.prometheusjava.controller.userapi;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequest {
    private String name;
    private String email;
    private String password;
    private String organisation;
    private Boolean isAdmin;
}
