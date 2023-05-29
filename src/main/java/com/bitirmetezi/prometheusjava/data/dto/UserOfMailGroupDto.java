package com.bitirmetezi.prometheusjava.data.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOfMailGroupDto {
    private Long id;
    private String name;
    private String email;
    private String organisation;
}
