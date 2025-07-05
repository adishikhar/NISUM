package com.nisum.demo.service;



import com.nisum.demo.email.EmailSender;
import com.nisum.demo.model.User;
import com.nisum.demo.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;
    private final EmailSender emailSender;

    public UserService(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public void processUser(Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            handleMissingUser(id);
            throw new RuntimeException("User not found");
        }
        emailSender.send(user, "Welcome Back");
    }

    public void handleMissingUser(Long id) {
        System.out.println("Fallback logic for missing user: " + id);
    }
}

