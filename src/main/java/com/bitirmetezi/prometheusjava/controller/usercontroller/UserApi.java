package com.bitirmetezi.prometheusjava.controller.usercontroller;

import com.bitirmetezi.prometheusjava.controller.BaseResponse;
import com.bitirmetezi.prometheusjava.service.userservice.UserService;
import com.bitirmetezi.prometheusjava.service.userservice.UserServiceOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserApi {

    @Autowired
    UserService userService;

    @GetMapping
    public BaseResponse<List<UserServiceOutput>> getAll(){
        List<UserServiceOutput> serviceOutputs = userService.findAll();

        BaseResponse<List<UserServiceOutput>> response = new BaseResponse<>();
        if (!serviceOutputs.isEmpty()){
            response.setResponseCode(1);
            response.setResponseDesc("successfully completed");
            response.setData(serviceOutputs);
        }
        else {
            response.setResponseCode(2);
            response.setResponseDesc("null value returned");
        }
        return response;
    }
}
