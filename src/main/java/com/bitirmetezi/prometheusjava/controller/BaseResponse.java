package com.bitirmetezi.prometheusjava.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {
    private int responseCode;
    private String responseDesc;
    private T data;
}
