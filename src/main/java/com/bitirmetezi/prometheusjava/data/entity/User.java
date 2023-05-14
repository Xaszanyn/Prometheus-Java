package com.bitirmetezi.prometheusjava.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
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
