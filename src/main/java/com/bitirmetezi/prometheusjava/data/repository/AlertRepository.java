package com.bitirmetezi.prometheusjava.data.repository;

import com.bitirmetezi.prometheusjava.data.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AlertRepository extends JpaRepository<Alert, Long> {

    @Query(value = "Select a From Alert a Where a.isActive = true")
    List<Alert> findAllActiveAlerts();
}
