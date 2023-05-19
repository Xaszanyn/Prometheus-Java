package com.bitirmetezi.prometheusjava.core.mappers;

import com.bitirmetezi.prometheusjava.controller.userapi.UserCreateRequest;
import com.bitirmetezi.prometheusjava.controller.userapi.UserUpdateRequest;
import com.bitirmetezi.prometheusjava.data.entity.User;
import com.bitirmetezi.prometheusjava.service.userservice.UserCreateServiceInput;
import com.bitirmetezi.prometheusjava.service.userservice.UserServiceOutput;
import com.bitirmetezi.prometheusjava.service.userservice.UserUpdateServiceInput;

import java.util.List;
import java.util.Optional;

public interface UserMapper {
    User map(UserServiceOutput serviceOutput);

    UserServiceOutput map(Optional<User> optionalUser);

    List<UserServiceOutput> map(List<User> serviceOutputs);

    UserCreateServiceInput map(UserCreateRequest request);

    User map(UserCreateServiceInput serviceInput);

    UserUpdateServiceInput map(UserUpdateRequest request);

    User map(UserUpdateServiceInput serviceInput);

}
