package com.bitirmetezi.prometheusjava.service.alerthistoryservice;

import com.bitirmetezi.prometheusjava.data.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bitirmetezi.prometheusjava.core.mappers.HistoryMapper.*;

@Service
@RequiredArgsConstructor
public class HistoryServiceImp implements HistoryService{

    @Autowired
    private final HistoryRepository historyRepository;

    @Override
    public List<HistoryServiceOutput> findAll() {
        return map(historyRepository.findAllAlertHistories());
    }

    @Override
    public HistoryServiceOutput findByAlertId(Long id) {
        return null;
    }

    @Override
    public String saveHistory(HistoryCreateServiceInput serviceInput) {
        return null;
    }
}
