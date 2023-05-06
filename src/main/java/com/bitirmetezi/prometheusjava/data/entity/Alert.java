package com.bitirmetezi.prometheusjava.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "alert")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Alert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "query")
    @NonNull
    private String query;
    @Column(name = "insert_user_id")
    @NonNull
    private Long insertUserId;
    @Column(name = "insert_time")
    @NonNull
    private BigDecimal insertTime;
    @Column(name = "update_time")
    @NonNull
    private BigDecimal updateTime;
    @Column(name = "is_active")
    @NonNull
    private Boolean isActive;
    @Column(name = "severity")
    @NonNull
    private String severity;
    @Column(name = "threshold_sign")
    @NonNull
    private String thresholdSign;
    @Column(name = "threshold_value")
    @NonNull
    private Integer thresholdValue;
    @Column(name = "time_interval")
    @NonNull
    private Integer timeInterval;
    @Column(name = "time_value")
    @NonNull
    private Character timeValue;
    @Column(name = "start_active_time")
    @NonNull
    private BigDecimal startActiveTime;
    @Column(name = "end_active_time")
    @NonNull
    private BigDecimal endActiveTime;

    @OneToMany(mappedBy = "alert")
    private List<AlertHistory> alertHistories;
}
