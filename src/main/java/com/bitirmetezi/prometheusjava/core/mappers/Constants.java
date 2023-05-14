package com.bitirmetezi.prometheusjava.core.mappers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Constants {
    SUCCESS("success"),
    FAILED("failed"),
    NOT_FOUND("not found");

    private final String name;
}