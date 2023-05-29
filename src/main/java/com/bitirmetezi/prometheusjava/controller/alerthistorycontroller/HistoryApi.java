package com.bitirmetezi.prometheusjava.controller.alerthistorycontroller;

import com.bitirmetezi.prometheusjava.controller.BaseResponse;
import com.bitirmetezi.prometheusjava.service.alerthistoryservice.HistoryService;
import com.bitirmetezi.prometheusjava.service.alerthistoryservice.HistoryServiceOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/histories")
public class HistoryApi {

    private final HistoryService historyService;

    @GetMapping
    public BaseResponse<List<HistoryServiceOutput>> findAll(){
        List<HistoryServiceOutput> outputList = historyService.findAll();

        BaseResponse<List<HistoryServiceOutput>> response = new BaseResponse<>();
        fillResponse(outputList, response);
        return response;
    }

    @GetMapping("/getAllByAlertId/{id}")
    public BaseResponse<List<HistoryServiceOutput>> findAllAlertsByAlertId(@PathVariable("id") Long id){
        List<HistoryServiceOutput> outputList = historyService.findByAlertId(id);

        BaseResponse<List<HistoryServiceOutput>> response = new BaseResponse<>();
        fillResponse(outputList, response);
        return response;
    }

    private static void fillResponse(List<HistoryServiceOutput> serviceOutputs, BaseResponse<List<HistoryServiceOutput>> response) {
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
}
