package com.bitirmetezi.prometheusjava.controller.alertcontroller;

import com.bitirmetezi.prometheusjava.controller.BaseResponse;
import com.bitirmetezi.prometheusjava.service.alertservice.AlertService;
import com.bitirmetezi.prometheusjava.service.alertservice.AlertServiceOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bitirmetezi.prometheusjava.core.mappers.AlertMapper.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/alerts")
public class AlertApi {

    @Autowired
    private final AlertService alertService;

    @GetMapping
    public BaseResponse<List<AlertServiceOutput>> getAll(){
        List<AlertServiceOutput> outputList = alertService.findAll();

        BaseResponse<List<AlertServiceOutput>> response = new BaseResponse<>();

        fillResponse(outputList, response);
        return response;
    }

    @GetMapping("/{id}")
    public BaseResponse<AlertServiceOutput> getById(@PathVariable("id") Long id){
        AlertServiceOutput serviceOutput = alertService.findById(id);

        BaseResponse<AlertServiceOutput> response = new BaseResponse<>();

        fillResponse(serviceOutput, response);
        return response;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<String> createAlert(@RequestBody AlertCreateRequest request){
        String output = alertService.saveAlert(map(request));

        BaseResponse<String> response = new BaseResponse<>();
        fillResponse(output, response);
        return response;
    }

    @PutMapping("/update")
    public BaseResponse<String> updateAlert(@RequestBody AlertUpdateRequest request){
        String output = alertService.updateAlert(map(request));

        BaseResponse<String> response = new BaseResponse<>();
        fillResponse(output, response);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse<String> deleteAlert(@PathVariable("id") Long id){
        String output = alertService.deleteAlert(id);

        BaseResponse<String> response = new BaseResponse<>();
        fillResponse(output, response);
        return response;
    }


    private static void fillResponse(AlertServiceOutput serviceOutput, BaseResponse<AlertServiceOutput> response) {
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

    private static void fillResponse(List<AlertServiceOutput> serviceOutputs, BaseResponse<List<AlertServiceOutput>> response) {
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
