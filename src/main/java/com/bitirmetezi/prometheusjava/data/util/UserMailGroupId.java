package com.bitirmetezi.prometheusjava.data.util;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
@Builder
@AllArgsConstructor
public class UserMailGroupId implements Serializable {
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "MAIL_LIST_ID")
    private Long mailListId;
}
