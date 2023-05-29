package com.bitirmetezi.prometheusjava.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.io.Serializable;

@Entity
@Table(name = "ALERT_HISTORY")
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class AlertHistory implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ALERT_VALUE")
    @NonNull
    private Double alertValue;
    @Column(name = "ALERT_TIME")
    @NonNull
    private Long alertTime;
    @ManyToOne
    @JoinColumn(name = "ALERT_ID")
    private Alert alert;
}
