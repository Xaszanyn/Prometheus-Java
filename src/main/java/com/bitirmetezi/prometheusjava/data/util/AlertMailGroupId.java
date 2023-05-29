package com.bitirmetezi.prometheusjava.data.util;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
@AllArgsConstructor
@Builder
public class AlertMailGroupId implements Serializable {
    @Column(name = "ALERT_ID")
    private Long alertId;
    @Column(name = "MAIL_LIST_ID")
    private Long mailListId;
}
