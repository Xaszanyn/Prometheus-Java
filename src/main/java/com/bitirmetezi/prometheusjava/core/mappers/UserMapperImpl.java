package com.bitirmetezi.prometheusjava.core.mappers;

import com.bitirmetezi.prometheusjava.controller.userapi.UserCreateRequest;
import com.bitirmetezi.prometheusjava.controller.userapi.UserUpdateRequest;
import com.bitirmetezi.prometheusjava.data.entity.User;
import com.bitirmetezi.prometheusjava.service.userservice.UserCreateServiceInput;
import com.bitirmetezi.prometheusjava.service.userservice.UserServiceOutput;
import com.bitirmetezi.prometheusjava.service.userservice.UserUpdateServiceInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserMapperImpl{

    public static User map(UserServiceOutput serviceOutput) {
        return User.builder()
                .id(serviceOutput.getId())
                .name(serviceOutput.getName())
                .email(serviceOutput.getEmail())
                .organisation(serviceOutput.getOrganisation())
                .password(serviceOutput.getPassword())
                .isAdmin(serviceOutput.getIsAdmin())
                .build();
    }

    public static UserServiceOutput map(Optional<User> optionalUser) {
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            return UserServiceOutput.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .organisation(user.getOrganisation())
                    .isAdmin(user.getIsAdmin())
                    .build();
        }
        return null;
    }

    public static List<UserServiceOutput> map(List<User> serviceOutputs) {
        List<UserServiceOutput> outputList = new ArrayList<>();
        for (User user : serviceOutputs){
            outputList.add(UserServiceOutput.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .organisation(user.getOrganisation())
                    .isAdmin(user.getIsAdmin())
                    .build());
        }
        return outputList;
    }

    public static UserCreateServiceInput map(UserCreateRequest request) {
        return UserCreateServiceInput.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .organisation(request.getOrganisation())
                .isAdmin(request.getIsAdmin())
                .build();
    }

    public static User map(UserCreateServiceInput serviceInput) {
        return User.builder()
                .name(serviceInput.getName())
                .email(serviceInput.getEmail())
                .password(serviceInput.getPassword())
                .organisation(serviceInput.getOrganisation())
                .isAdmin(serviceInput.getIsAdmin())
                .build();
    }

    public static UserUpdateServiceInput map(UserUpdateRequest request) {
        return UserUpdateServiceInput.builder()
                .id(request.getId())
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .organisation(request.getOrganisation())
                .isAdmin(request.getIsAdmin())
                .build();
    }

    public static User map(UserUpdateServiceInput serviceInput) {
        return User.builder()
                .id(serviceInput.getId())
                .name(serviceInput.getName())
                .email(serviceInput.getEmail())
                .password(serviceInput.getPassword())
                .organisation(serviceInput.getOrganisation())
                .isAdmin(serviceInput.getIsAdmin())
                .build();
    }
}
