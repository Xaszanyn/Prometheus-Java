package com.bitirmetezi.prometheusjava.service.maillistservice;

import com.bitirmetezi.prometheusjava.data.entity.MailList;
import com.bitirmetezi.prometheusjava.data.repository.MailListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bitirmetezi.prometheusjava.core.mappers.MailListMapper.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class MailListServiceImp implements MailListService{

    @Autowired
    private final MailListRepository mailListRepository;

    @Override
    public List<MailListServiceOutput> findAll() {
        return map(mailListRepository.findAll());
    }

    @Override
    public MailListServiceOutput findById(Long id) {
        return map(mailListRepository.findById(id));
    }

    @Override
    public String createMailList(MailListCreateServiceInput serviceInput) {
        mailListRepository.save(map(serviceInput));
        return "success";
    }

    @Override
    public String updateMailList(MailListUpdateServiceInput serviceInput) {
        if (mailListRepository.existsById(serviceInput.getId())){
            MailList mailList = mailListRepository.findById(serviceInput.getId()).get();
            MailList newMailList = map(serviceInput);
            newMailList.setInsertTime(mailList.getInsertTime());
            newMailList.setInsertUserId(mailList.getInsertUserId());
            mailListRepository.save(newMailList);
            return "success";
        }
        return "not found";
    }

    @Override
    public String deleteMailList(Long id) {
        if (mailListRepository.existsById(id)){
            mailListRepository.deleteById(id);
            return "success";
        }
        return "not found";
    }
}
