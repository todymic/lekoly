package com.tody.lekoly.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
class ResponseExceptionHandler {

    @ExceptionHandler({NoResourceFoundException.class, ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handleNotFoundException(Exception exception) {
       ApiError error = new ApiError(
               LocalDateTime.now(),
               "Resource not found",
               HttpStatus.NOT_FOUND.value(),
               exception.getMessage()
       );

       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler({DataIntegrityViolationException.class, DuplicateEntityException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> handleUniqueConstraintViolationException(Exception exception) {
        ApiError error =   new ApiError(
                LocalDateTime.now(),
                "Unique constraint violation",
                HttpStatus.CONFLICT.value(),
                exception.getMessage()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
