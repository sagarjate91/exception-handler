package com.exception.exception_handler.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        ResponseEntity<String> responseEntity = ResponseEntity.badRequest().body("IllegalArgumentException : " + ex.getMessage());
        return responseEntity;
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException ex) {
        ResponseEntity<String> responseEntity = ResponseEntity.badRequest().body("ArithmeticException : " + ex.getMessage());
        return responseEntity;
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {
        ResponseEntity<String> responseEntity = ResponseEntity.badRequest().body("CustomException : " + ex.getMessage());
        return responseEntity;
    }

}
