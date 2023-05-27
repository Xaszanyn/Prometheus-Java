package com.bitirmetezi.prometheusjava.service.alertservice;

import com.bitirmetezi.prometheusjava.data.entity.Alert;
import com.bitirmetezi.prometheusjava.data.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.bitirmetezi.prometheusjava.core.mappers.AlertMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlertServiceImp implements AlertService{

    @Autowired
    private final AlertRepository alertRepository;
    @Override
    public List<AlertServiceOutput> findAll() {
        List<Alert> outputList = alertRepository.findAll();

        if (CollectionUtils.isEmpty(outputList)){
            log.error("Can't find any data.");
            return new ArrayList<>();
        }
        return map(outputList);
    }

    @Override
    public AlertServiceOutput findById(Long id) {
        return map(alertRepository.findById(id));
    }

    @Override
    public String saveAlert(AlertCreateServiceInput input) {
        alertRepository.save(map(input));
        return "success";
    }

    @Override
    public String updateAlert(AlertUpdateServiceInput input) {
        if (alertRepository.existsById(input.getId())){
            alertRepository.save(map(input));
            return "success";
        }
        return "not found";
    }

    @Override
    public String deleteAlert(Long id) {
        if (alertRepository.existsById(id)){
            alertRepository.deleteById(id);
            return "success";
        }
        return "not found";
    }
}
