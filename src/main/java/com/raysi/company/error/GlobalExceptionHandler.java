package com.raysi.company.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException rs){
        ErrorMessage errorMessage = new ErrorMessage(rs.getErrorCode(), rs.getErrorMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("Accept-Datetime")
                .body(errorMessage);

    }
}
