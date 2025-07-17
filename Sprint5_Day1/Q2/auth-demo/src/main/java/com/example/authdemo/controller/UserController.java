package com.example.authdemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/dao/hello")
    public String daoHello(Authentication auth) {
        return "DAO Authenticated as: " + auth.getName();
    }

    @GetMapping("/ldap/hello")
    public String ldapHello(Authentication auth) {
        return "LDAP Authenticated as: " + auth.getName();
    }
}

