package com.bitirmetezi.prometheusjava.data.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertHistoryDto {
    private Long id;
    private String name;
    private String severity;
    private String thresholdSign;
    private Integer thresholdValue;
    private Double alertValue;
    private Long alertTime;
}
