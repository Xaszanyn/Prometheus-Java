package com.bitirmetezi.prometheusjava.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ALERT")
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class Alert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    @NonNull
    private String name;
    @Column(name = "QUERY")
    @NonNull
    private String query;
    @Column(name = "INSERT_USER_ID")
    @NonNull
    private Long insertUserId;
    @Column(name = "INSERT_TIME")
    @NonNull
    private Long insertTime;
    @Column(name = "UPDATE_TIME")
    @NonNull
    private Long updateTime;
    @Column(name = "IS_ACTIVE")
    @NonNull
    private Boolean isActive;
    @Column(name = "SEVERITY")
    @NonNull
    private String severity;
    @Column(name = "THRESHOLD_SIGN")
    @NonNull
    private String thresholdSign;
    @Column(name = "THRESHOLD_VALUE")
    @NonNull
    private Integer thresholdValue;
    @Column(name = "TIME_INTERVAL")
    @NonNull
    private Integer timeInterval;
    @Column(name = "TIME_VALUE")
    @NonNull
    private Character timeValue;
    @Column(name = "START_ACTIVE_TIME")
    @NonNull
    private Long startActiveTime;
    @Column(name = "END_ACTIVE_TIME")
    @NonNull
    private Long endActiveTime;

    @OneToMany(mappedBy = "alert")
    private List<AlertHistory> alertHistories;
}
