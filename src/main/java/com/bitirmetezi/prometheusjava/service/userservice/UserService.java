package com.bitirmetezi.prometheusjava.service.userservice;

import java.util.List;

public interface UserService {
    List<UserServiceOutput> findAll();
    UserServiceOutput findById(Long id);
}
