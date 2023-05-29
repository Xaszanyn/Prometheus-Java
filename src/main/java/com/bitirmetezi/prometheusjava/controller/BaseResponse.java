package com.bitirmetezi.prometheusjava.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BaseResponse<T> {
    private int responseCode;
    private String responseDesc;
    private T data;
}
