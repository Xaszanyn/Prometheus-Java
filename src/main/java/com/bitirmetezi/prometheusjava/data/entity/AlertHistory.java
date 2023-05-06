package com.bitirmetezi.prometheusjava.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "alert_history")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AlertHistory implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "alert_value")
    @NonNull
    private Double alertValue;
    @Column(name = "alert_time")
    @NonNull
    private BigDecimal alertTime;
    @ManyToOne
    @JoinColumn(name = "alert_id")
    private Alert alert;
}
