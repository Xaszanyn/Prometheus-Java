package com.bitirmetezi.prometheusjava.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "\"USER\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    @Column(name = "\"ID\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "\"NAME\"")
    private String name;
    @Column(name = "\"EMAIL\"")
    private String email;
    @Column(name = "\"PASSWORD\"")
    private String password;
    @Column(name = "\"ORGANISATION\"")
    private String organisation;
    @Column(name = "\"IS_ADMIN\"")
    private Boolean isAdmin;
}
