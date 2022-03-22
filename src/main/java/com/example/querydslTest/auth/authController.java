package com.example.querydslTest.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}
