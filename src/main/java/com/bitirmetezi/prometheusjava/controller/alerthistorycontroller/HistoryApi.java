package com.bitirmetezi.prometheusjava.controller.alerthistorycontroller;

import com.bitirmetezi.prometheusjava.service.alerthistoryservice.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/histories")
public class HistoryApi {

    private final HistoryService historyService;
}
