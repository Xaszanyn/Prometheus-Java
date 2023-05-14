package com.bitirmetezi.prometheusjava.controller.userapi;

import com.bitirmetezi.prometheusjava.controller.BaseResponse;
import com.bitirmetezi.prometheusjava.service.userservice.UserService;
import com.bitirmetezi.prometheusjava.service.userservice.UserServiceOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.bitirmetezi.prometheusjava.core.mappers.ResponseConstants.NULL;
import static com.bitirmetezi.prometheusjava.core.mappers.ResponseConstants.SUCCESSFUL;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserApi {

    @Autowired
    private final UserService userService;

    @GetMapping("/getAll")
    BaseResponse<List<UserServiceOutput>> findAll(){
        List<UserServiceOutput> serviceOutputs = userService.findAll();

        BaseResponse<List<UserServiceOutput>> response = new BaseResponse<>();
        if (!serviceOutputs.isEmpty()){
            response.setResponseCode(SUCCESSFUL.getResponseCode());
            response.setResponseDesc(SUCCESSFUL.getResponseDesc());
            response.setData(serviceOutputs);
        }
        else{
            response.setResponseCode(NULL.getResponseCode());
            response.setResponseDesc(NULL.getResponseDesc());
        }

        return response;
    }

    @GetMapping("/getById/{id}")
    BaseResponse<UserServiceOutput> findById(@RequestParam("id") Long id){
        UserServiceOutput serviceOutput = userService.findById(id);

        BaseResponse<UserServiceOutput> response = new BaseResponse<>();
        if (serviceOutput != null){
            response.setResponseCode(SUCCESSFUL.getResponseCode());
            response.setResponseDesc(SUCCESSFUL.getResponseDesc());
            response.setData(serviceOutput);
        }
        else{
            response.setResponseCode(NULL.getResponseCode());
            response.setResponseDesc(NULL.getResponseDesc());
        }

        return response;
    }

}
