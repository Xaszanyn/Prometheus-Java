package com.bitirmetezi.prometheusjava.data.entity;

import com.bitirmetezi.prometheusjava.data.util.AlertMailGroupId;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "ALERT_MAIL_GROUP")
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class AlertMailGroup implements Serializable {

    @EmbeddedId
    private AlertMailGroupId id;
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
    @JoinColumn(name = "ALERT_ID", insertable = false, updatable = false)
    private Alert alert;
    @ManyToOne
    @JoinColumn(name = "MAIL_LIST_ID", insertable = false, updatable = false)
    private MailList mailList;
}
