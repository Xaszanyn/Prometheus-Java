package com.bitirmetezi.prometheusjava.service.alerthistoryservice;

import com.bitirmetezi.prometheusjava.data.entity.Alert;
import com.bitirmetezi.prometheusjava.data.entity.AlertHistory;
import com.bitirmetezi.prometheusjava.data.repository.AlertRepository;
import com.bitirmetezi.prometheusjava.data.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import static com.bitirmetezi.prometheusjava.core.mappers.HistoryMapper.*;

@Service
@RequiredArgsConstructor
public class HistoryServiceImp implements HistoryService{

    @Autowired
    private final HistoryRepository historyRepository;
    @Autowired
    private final AlertRepository alertRepository;

    @Override
    public List<HistoryServiceOutput> findAll() {
        return map(historyRepository.findAllAlertHistories());
    }

    @Override
    public List<HistoryServiceOutput> findByAlertId(Long id) {
        return map(historyRepository.findAlertHistoriesById(id));
    }

    @Override
    public String saveHistory(HistoryCreateServiceInput serviceInput) {
        AlertHistory alertHistory = new AlertHistory();
        Optional<Alert> optionalAlert = alertRepository.findById(serviceInput.getAlertId());
        Alert alert;
        if (optionalAlert.isPresent()){
            alert = optionalAlert.get();
            alertHistory.setAlert(alert);
            alertHistory.setAlertValue(serviceInput.getAlertValue());
            alertHistory.setAlertTime(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(3)));
            historyRepository.save(alertHistory);
            return "success";
        }
        return "alert not found";
    }
}
