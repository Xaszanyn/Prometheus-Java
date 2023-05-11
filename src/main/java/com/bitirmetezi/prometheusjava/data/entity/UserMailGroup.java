package com.bitirmetezi.prometheusjava.data.entity;

import com.bitirmetezi.prometheusjava.data.util.UserMailGroupId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "user_mail_group")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserMailGroup implements Serializable {
    @EmbeddedId
    private UserMailGroupId id;
    @Column(name = "insert_time")
    @NonNull
    private BigDecimal insertTime;
    @Column(name = "update_time")
    @NonNull
    private BigDecimal updateTime;
    @Column(name = "insert_user_id")
    @NonNull
    private Long insertUserId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "mail_list_id", insertable = false, updatable = false)
    private MailList mailList;
}
