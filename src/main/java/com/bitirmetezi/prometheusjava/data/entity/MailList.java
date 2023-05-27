package com.bitirmetezi.prometheusjava.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "MAIL_LIST")
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class MailList implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    @NonNull
    private String name;
    @Column(name = "INSERT_TIME")
    @NonNull
    private Long insertTime;
    @Column(name = "UPDATE_TIME")
    @NonNull
    private Long updateTime;
    @Column(name = "INSERT_USER_ID")
    @NonNull
    private Long insertUserId;
    @Column(name = "LAST_UPDATE_USER_ID")
    private Long lastUpdateUserId;

}
