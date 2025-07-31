package com.tody.lekoly.common.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ApiError {

    private final String message;
    private final Integer code;
    private final LocalDateTime time;
    private final List<Error> errors;

    public ApiError(String message, Integer code, LocalDateTime time, List<Error> errors) {

        this.message = message;
        this.code = code;
        this.time = time;
        this.errors = errors;

    }


    public ApiError(String message, Integer code, LocalDateTime time) {
        this(message, code, time, null);
    }
}
