package com.bitirmetezi.prometheusjava.data.util;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class AlertMailGroupId implements Serializable {
    @Column(name = "alert_id")
    private Long alertId;
    @Column(name = "mail_list_id")
    private Long mailListId;
}
