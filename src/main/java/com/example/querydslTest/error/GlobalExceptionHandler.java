package com.example.querydslTest.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(value = { ConstraintViolationException.class, DataIntegrityViolationException.class})
//    protected ResponseEntity<ErrorResponse> handleDataException() {
//        log.error("handleDataException throw Exception : {}", DUPLICATE_RESOURCE);
//        return ErrorResponse.toResponseEntity(DUPLICATE_RESOURCE);
//    }

    @ExceptionHandler(value = { CreateException.class })
    protected ResponseEntity<ErrorResponse> handleCustomException(CreateException e) {
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
