package com.bitirmetezi.prometheusjava.service.maillistservice;

import com.bitirmetezi.prometheusjava.data.entity.MailList;
import com.bitirmetezi.prometheusjava.data.entity.User;
import com.bitirmetezi.prometheusjava.data.entity.UserMailGroup;
import com.bitirmetezi.prometheusjava.data.repository.MailListRepository;
import com.bitirmetezi.prometheusjava.data.repository.UserMailGroupRepository;
import com.bitirmetezi.prometheusjava.data.repository.UserRepository;
import com.bitirmetezi.prometheusjava.data.util.UserMailGroupId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import static com.bitirmetezi.prometheusjava.core.mappers.MailListMapper.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class MailListServiceImp implements MailListService{

    @Autowired
    private final MailListRepository mailListRepository;
    private final UserRepository userRepository;
    private final UserMailGroupRepository userMailGroupRepository;

    @Override
    public List<MailListServiceOutput> findAll() {
        List<MailListServiceOutput> serviceOutput = map(mailListRepository.findAll());
        for (MailListServiceOutput  serviceOutput1 : serviceOutput){
            serviceOutput1.setUsers(userRepository.findUsersByMailListId(serviceOutput1.getId()));
        }
        return serviceOutput;
    }

    @Override
    public MailListServiceOutput findById(Long id) {
        MailListServiceOutput serviceOutput = map(mailListRepository.findById(id));
        serviceOutput.setUsers(userRepository.findUsersByMailListId(serviceOutput.getId()));
        return serviceOutput;
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

    @Override
    public String addUserToMailList(AddUserToMailListServiceInput serviceInput) {
        Optional<User> optionalUser = userRepository.findById(serviceInput.getUserId());
        Optional<MailList> optionalMailList = mailListRepository.findById(serviceInput.getMailListId());
        if (optionalMailList.isPresent() && optionalMailList.isPresent()){
            User user = optionalUser.get();
            MailList mailList = optionalMailList.get();

            UserMailGroup userMailGroup = new UserMailGroup(UserMailGroupId.builder().userId(serviceInput.getUserId()).mailListId(serviceInput.getMailListId()).build(),
                    LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(3)),
                    LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(3)),
            serviceInput.getInsertUserId(), user, mailList);

            userMailGroupRepository.save(userMailGroup);
            return "success";
        }
        return "user or mail list does not exist or not found.";

    }

    @Override
    public String deleteUserFromMailList(Long mailListId, Long userId) {
        if (mailListRepository.existsById(mailListId) && userRepository.existsById(userId)){
            userMailGroupRepository.deleteById(UserMailGroupId.builder().mailListId(mailListId).userId(userId).build());
            return "success";
        }
        return "not found";
    }
}
