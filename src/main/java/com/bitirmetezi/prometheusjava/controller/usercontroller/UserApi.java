package com.bitirmetezi.prometheusjava.controller.usercontroller;

import com.bitirmetezi.prometheusjava.controller.BaseResponse;
import com.bitirmetezi.prometheusjava.core.mappers.UserMapper;
import com.bitirmetezi.prometheusjava.service.userservice.UserService;
import com.bitirmetezi.prometheusjava.service.userservice.UserServiceOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        fillResponse(serviceOutputs, response);
        return response;
    }



    @GetMapping("/{id}")
    public BaseResponse<UserServiceOutput> getById(@PathVariable("id") Long id){
        UserServiceOutput serviceOutput = userService.findById(id);

        BaseResponse<UserServiceOutput> response = new BaseResponse<>();
        fillResponse(serviceOutput, response);
        return response;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<String> createUser(@RequestBody UserCreateRequest request){
        String result = userService.createUser(UserMapper.map(request));

        BaseResponse<String> response = new BaseResponse<>();
        fillResponse(result, response);
        return response;
    }

    @PutMapping("/update")
    public BaseResponse<String> updateUser(@RequestBody UserUpdateRequest request){
        String result = userService.updateUser(UserMapper.map(request));

        BaseResponse<String> response = new BaseResponse<>();
        fillResponse(result, response);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse<String> deleteUser(@PathVariable("id") Long id){
        String result = userService.deleteUser(id);

        BaseResponse<String> response = new BaseResponse<>();
        fillResponse(result, response);
        return response;
    }


    private static void fillResponse(UserServiceOutput serviceOutput, BaseResponse<UserServiceOutput> response) {
        if(serviceOutput != null){
            response.setResponseCode(1);
            response.setResponseDesc("successfully completed");
            response.setData(serviceOutput);
        }
        else {
            response.setResponseCode(2);
            response.setResponseDesc("null value returned");
        }
    }

    private static void fillResponse(List<UserServiceOutput> serviceOutputs, BaseResponse<List<UserServiceOutput>> response) {
        if (!serviceOutputs.isEmpty()){
            response.setResponseCode(1);
            response.setResponseDesc("successfully completed");
            response.setData(serviceOutputs);
        }
        else {
            response.setResponseCode(2);
            response.setResponseDesc("null value returned");
        }
    }

    private static void fillResponse(String result, BaseResponse<String> response) {
        if(result.equals("success")){
            response.setResponseCode(1);
            response.setResponseDesc("successfully completed");
        }
        else {
            response.setResponseCode(2);
            response.setResponseDesc("null value returned");
        }
    }
}
