package com.bitirmetezi.prometheusjava.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "user")
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @NonNull
    private String password;
    @Column(name = "organisation")
    private String organisation;
    @Column(name = "is_admin")
    @NonNull
    private Boolean isAdmin;
}
