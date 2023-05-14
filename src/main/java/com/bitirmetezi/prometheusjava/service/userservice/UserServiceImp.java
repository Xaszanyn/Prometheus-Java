package com.bitirmetezi.prometheusjava.service.userservice;

import com.bitirmetezi.prometheusjava.core.mappers.UserMapper;
import com.bitirmetezi.prometheusjava.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
