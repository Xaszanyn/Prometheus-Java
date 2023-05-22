package com.bitirmetezi.prometheusjava.service.maillistservice;

import java.util.List;

public interface MailListService {
    List<MailListServiceOutput> findAll();
    MailListServiceOutput findById(Long id);
    String createMailList(MailListCreateServiceInput serviceInput);
    String updateMailList(MailListUpdateServiceInput serviceInput);
    String deleteMailList(Long id);
}
