package com.bitirmetezi.prometheusjava.service.alerthistoryservice;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HistoryCreateServiceInput {
    private Long alertId;
    private Double alertValue;
}
