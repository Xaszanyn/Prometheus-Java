package com.bitirmetezi.prometheusjava.service.userservice;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserServiceOutput {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String organisation;
    private Boolean isAdmin;
}
