package com.bitirmetezi.prometheusjava.service.userservice;

import com.bitirmetezi.prometheusjava.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bitirmetezi.prometheusjava.core.mappers.UserMapper.*;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    @Autowired
    private final UserRepository userRepository;
    @Override
    public List<UserServiceOutput> findAll() {
        return map(userRepository.findAll());
    }

    @Override
    public UserServiceOutput findById(Long id) {
        return map(userRepository.findById(id));
    }

    @Override
    public String createUser(UserCreateServiceInput serviceInput) {
        userRepository.save(map(serviceInput));
        return "success";
    }

    @Override
    public String updateUser(UserUpdateServiceInput serviceInput) {
        if (userRepository.existsById(serviceInput.getId())){
            userRepository.save(map(serviceInput));
            return "success";
        }
        return "not found";
    }

    @Override
    public String deleteUser(Long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "success";
        }
        return "not found";
    }
}
