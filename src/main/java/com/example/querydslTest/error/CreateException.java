package com.example.querydslTest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateException extends RuntimeException {
    private final ErrorCode errorCode;
}
