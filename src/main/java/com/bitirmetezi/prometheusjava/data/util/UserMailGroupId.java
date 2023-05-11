package com.bitirmetezi.prometheusjava.data.util;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class UserMailGroupId implements Serializable {
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "mail_list_id")
    private Long mailListId;
}
