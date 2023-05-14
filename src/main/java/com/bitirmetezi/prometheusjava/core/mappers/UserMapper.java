package com.bitirmetezi.prometheusjava.core.mappers;

import com.bitirmetezi.prometheusjava.data.entity.User;
import com.bitirmetezi.prometheusjava.service.userservice.UserServiceOutput;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(UserServiceOutput serviceOutput);

    UserServiceOutput map(Optional<User> user);

    List<UserServiceOutput> map(List<User> serviceOutputs);

}
