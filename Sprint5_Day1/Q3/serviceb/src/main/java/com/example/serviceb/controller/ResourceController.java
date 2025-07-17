package com.example.serviceb.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/api/data")
    public String secureData() {
        return "Protected data from Service B";
    }
}
