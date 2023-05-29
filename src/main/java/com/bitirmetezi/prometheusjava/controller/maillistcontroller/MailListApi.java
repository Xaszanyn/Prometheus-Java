package com.bitirmetezi.prometheusjava.controller.maillistcontroller;

import com.bitirmetezi.prometheusjava.controller.BaseResponse;
import com.bitirmetezi.prometheusjava.service.maillistservice.MailListService;
import com.bitirmetezi.prometheusjava.service.maillistservice.MailListServiceOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bitirmetezi.prometheusjava.core.mappers.MailListMapper.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mailLists")
public class MailListApi {

    @Autowired
    MailListService mailListService;

    @GetMapping
    public BaseResponse<List<MailListServiceOutput>> getAll(){
        List<MailListServiceOutput> serviceOutputs = mailListService.findAll();

        BaseResponse<List<MailListServiceOutput>> response = new BaseResponse<>();
        fillResponse(serviceOutputs, response);
        return response;
    }

    @GetMapping("/{id}")
    public BaseResponse<MailListServiceOutput> getById(@PathVariable("id") Long id){
        MailListServiceOutput serviceOutput = mailListService.findById(id);

        BaseResponse<MailListServiceOutput> response = new BaseResponse<>();
        fillResponse(serviceOutput, response);
        return response;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<String> createMailList(@RequestBody MailListCreateRequest request){
        String result = mailListService.createMailList(map(request));

        BaseResponse<String> response = new BaseResponse<>();
        fillResponse(result, response);
        return response;
    }

    @PutMapping("/update")
    public BaseResponse<String> updateMailList(@RequestBody MailListUpdateRequest request){
        String result = mailListService.updateMailList(map(request));

        BaseResponse<String> response = new BaseResponse<>();
        fillResponse(result, response);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse<String> deleteMailList(@PathVariable("id") Long id){
        String result = mailListService.deleteMailList(id);

        BaseResponse<String> response = new BaseResponse<>();
        fillResponse(result, response);
        return response;
    }

    private static void fillResponse(MailListServiceOutput serviceOutput, BaseResponse<MailListServiceOutput> response) {
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

    private static void fillResponse(List<MailListServiceOutput> serviceOutputs, BaseResponse<List<MailListServiceOutput>> response) {
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
