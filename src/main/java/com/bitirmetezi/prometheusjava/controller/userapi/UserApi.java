package com.bitirmetezi.prometheusjava.controller.userapi;

import com.bitirmetezi.prometheusjava.controller.BaseResponse;
import com.bitirmetezi.prometheusjava.core.mappers.ResponseConstants;
import com.bitirmetezi.prometheusjava.core.mappers.UserMapper;
import com.bitirmetezi.prometheusjava.service.userservice.UserCreateServiceInput;
import com.bitirmetezi.prometheusjava.service.userservice.UserService;
import com.bitirmetezi.prometheusjava.service.userservice.UserServiceOutput;
import com.bitirmetezi.prometheusjava.service.userservice.UserUpdateServiceInput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bitirmetezi.prometheusjava.core.mappers.Constants.*;
import static com.bitirmetezi.prometheusjava.core.mappers.ResponseConstants.NULL;
import static com.bitirmetezi.prometheusjava.core.mappers.ResponseConstants.SUCCESSFUL;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserApi {

    @Autowired
    private final UserService userService;
    @Autowired
    private final UserMapper userMapper;


    @GetMapping("/getAll")
    public BaseResponse<List<UserServiceOutput>> findAll(){
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
    public BaseResponse<UserServiceOutput> findById(@RequestParam("id") Long id){
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

    @PostMapping("/createUser")
    public BaseResponse<String> saveUser(@RequestBody UserCreateRequest request){
        UserCreateServiceInput serviceInput = userMapper.map(request);
        String result = userService.save(serviceInput);

        BaseResponse<String> response = new BaseResponse<>();

        if(result.equals(SUCCESS.getName())){
            response.setResponseCode(SUCCESSFUL.getResponseCode());
            response.setResponseDesc(SUCCESSFUL.getResponseDesc());
            response.setData(result);
        }
        else{
            response.setResponseCode(ResponseConstants.FAILED.getResponseCode());
            response.setResponseDesc(ResponseConstants.FAILED.getResponseDesc());
        }

        return response;
    }

    @PutMapping("/updateUser")
    public BaseResponse<String> updateUser(@RequestBody UserUpdateRequest request){
        UserUpdateServiceInput serviceInput = userMapper.map(request);
        String result = userService.update(serviceInput);

        BaseResponse<String> response = new BaseResponse<>();

        if(result.equals(SUCCESS.getName())){
            response.setResponseCode(SUCCESSFUL.getResponseCode());
            response.setResponseDesc(SUCCESSFUL.getResponseDesc());
            response.setData(result);
        }
        else if(result.equals(NOT_FOUND.getName())){
            response.setResponseCode(ResponseConstants.NOT_FOUND.getResponseCode());
            response.setResponseDesc(ResponseConstants.NOT_FOUND.getResponseDesc());
        }
        else{
            response.setResponseCode(ResponseConstants.FAILED.getResponseCode());
            response.setResponseDesc(ResponseConstants.FAILED.getResponseDesc());
        }

        return response;
    }

    @DeleteMapping("/deleteUser/{id}")
    public BaseResponse<String> deleteUser(@RequestParam("id")Long id){
        String result = userService.delete(id);

        BaseResponse<String> response = new BaseResponse<>();

        if(result.equals(SUCCESS.getName())){
            response.setResponseCode(SUCCESSFUL.getResponseCode());
            response.setResponseDesc(SUCCESSFUL.getResponseDesc());
            response.setData(result);
        }
        else if(result.equals(NOT_FOUND.getName())){
            response.setResponseCode(ResponseConstants.NOT_FOUND.getResponseCode());
            response.setResponseDesc(ResponseConstants.NOT_FOUND.getResponseDesc());
        }
        else{
            response.setResponseCode(ResponseConstants.FAILED.getResponseCode());
            response.setResponseDesc(ResponseConstants.FAILED.getResponseDesc());
        }

        return response;
    }

}
