package com.bitirmetezi.prometheusjava.service.userservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceOutput {
    private Long id;
    private String name;
    private String email;
    private String organisation;
    private Boolean isAdmin;
}
