package com.bitirmetezi.prometheusjava.service.userservice;

import com.bitirmetezi.prometheusjava.core.mappers.UserMapper;
import com.bitirmetezi.prometheusjava.data.entity.User;
import com.bitirmetezi.prometheusjava.data.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.bitirmetezi.prometheusjava.core.mappers.Constants.*;
import static com.bitirmetezi.prometheusjava.core.mappers.LogConstants.*;

@Slf4j
@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImp(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public List<UserServiceOutput> findAll() {
        return userMapper.map(userRepository.findAll());
    }

    @Override
    public UserServiceOutput findById(Long id) {
        return userMapper.map(userRepository.findById(id));
    }

    @Override
    public String save(UserCreateServiceInput serviceInput) {
        if (serviceInput != null){
            userRepository.save(userMapper.map(serviceInput));
            return SUCCESS.getName();
        }
        log.error(USER_REPOSITORY_ACCESS_ERROR.getName());
        return FAILED.getName();
    }

    @Override
    public String update(UserUpdateServiceInput serviceInput) {
        if (serviceInput != null){
            Optional<User> optionalUser = userRepository.findById(serviceInput.getId());
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                updateUser(serviceInput, user);
                userRepository.save(user);
                return SUCCESS.getName();
            }
            return NOT_FOUND.getName();
        }
        log.error(USER_REPOSITORY_ACCESS_ERROR.getName());
        return FAILED.getName();
    }

    @Override
    public String delete(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            userRepository.delete(optionalUser.get());
            return SUCCESS.getName();
        }
        return NOT_FOUND.getName();
    }

    private static void updateUser(UserUpdateServiceInput serviceInput, User user) {
        user.setEmail(serviceInput.getEmail());
        user.setName(serviceInput.getName());
        user.setPassword(serviceInput.getPassword());
        user.setOrganisation(serviceInput.getOrganisation());
        user.setIsAdmin(serviceInput.getIsAdmin());
    }
}
