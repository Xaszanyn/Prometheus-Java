package com.bitirmetezi.prometheusjava.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "mail_list")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MailList implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "insert_time")
    @NonNull
    private BigDecimal insertTime;
    @Column(name = "update_time")
    @NonNull
    private BigDecimal updateTime;
    @Column(name = "insert_user_id")
    @NonNull
    private Long insertUserId;
    @Column(name = "last_update_user_id")
    private Long lastUpdateUserId;
}
