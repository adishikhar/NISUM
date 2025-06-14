package com.nisum.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Division {

    @GetMapping("/divide")
    public int divide(@RequestParam int a , @RequestParam int b){
        if (b==0 ){
           throw new ArithmeticException("Division by zero");
        }
        return  a / b;
    }
}
