package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello, Authenticated User!";
    }

    @GetMapping("/api/admin")
    public String adminAccess() {
        return "Welcome Admin!";
    }
}
