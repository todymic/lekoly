package com.tody.lekoly.common.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiError {

    private final String message;
    private final Integer code;
    private final LocalDateTime time;


    public ApiError(String message, Integer code, LocalDateTime time) {
        this.message = message;
        this.code = code;
        this.time = time;
    }
}
