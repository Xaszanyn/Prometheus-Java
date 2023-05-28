package com.bitirmetezi.prometheusjava.data.repository;

import com.bitirmetezi.prometheusjava.data.dto.AlertHistoryDto;
import com.bitirmetezi.prometheusjava.data.entity.AlertHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<AlertHistory, Long> {

    @Query("Select new com.bitirmetezi.prometheusjava.data.dto.AlertHistoryDto(a.id, a.name, a.severity, a.thresholdSign, a.thresholdValue, h.alertValue, h.alertTime) From Alert a inner join a.alertHistories h order by h.alertTime DESC ")
    List<AlertHistoryDto> findAllAlertHistories();

    @Query("Select new com.bitirmetezi.prometheusjava.data.dto.AlertHistoryDto(a.id, a.name, a.severity, a.thresholdSign, a.thresholdValue, h.alertValue, h.alertTime) From Alert a inner join a.alertHistories h Where a.id =:alertId order by h.alertTime DESC ")
    List<AlertHistoryDto> findAlertHistoriesById(Long alertId);

}
