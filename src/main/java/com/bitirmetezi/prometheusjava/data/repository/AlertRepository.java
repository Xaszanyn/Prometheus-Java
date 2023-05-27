package com.bitirmetezi.prometheusjava.data.repository;

import com.bitirmetezi.prometheusjava.data.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {
}
