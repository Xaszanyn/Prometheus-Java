package com.bitirmetezi.prometheusjava.data.entity;

import com.bitirmetezi.prometheusjava.data.util.UserMailGroupId;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "USER_MAIL_GROUP")
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class UserMailGroup implements Serializable {
    @EmbeddedId
    private UserMailGroupId id;
    @Column(name = "INSERT_TIME")
    @NonNull
    private Long insertTime;
    @Column(name = "UPDATE_TIME")
    @NonNull
    private Long updateTime;
    @Column(name = "INSERT_USER_ID")
    @NonNull
    private Long insertUserId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", insertable = false, updatable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "MAIL_LIST_ID", insertable = false, updatable = false)
    private MailList mailList;
}
