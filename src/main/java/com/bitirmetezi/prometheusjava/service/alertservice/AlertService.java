package com.bitirmetezi.prometheusjava.service.alertservice;

import java.util.List;

public interface AlertService {
    List<AlertServiceOutput> findAll();
    AlertServiceOutput findById(Long id);
    String saveAlert(AlertCreateServiceInput input);
    String updateAlert(AlertUpdateServiceInput input);
    String deleteAlert(Long id);
    String addAlertToMailList(AddAlertToMailListServiceInput input);

    String deleteAlertFromMailList(Long alertId, Long mailListId);
}
