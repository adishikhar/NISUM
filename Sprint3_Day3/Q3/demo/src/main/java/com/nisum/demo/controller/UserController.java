package com.nisum.demo.controller;

import com.nisum.demo.model.UserRequestModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequestModel request) {
        return ResponseEntity.ok("User created");
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@Valid @RequestBody UserRequestModel request) {
        return ResponseEntity.ok("User updated");
    }
}
