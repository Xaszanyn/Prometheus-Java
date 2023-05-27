package com.bitirmetezi.prometheusjava.service.alerthistoryservice;

import java.util.List;

public interface HistoryService {
    List<HistoryServiceOutput> findAll();
    HistoryServiceOutput findByAlertId(Long id);
    String saveHistory(HistoryCreateServiceInput serviceInput);
}
