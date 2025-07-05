package com.nisum.demo.email;



import com.nisum.demo.model.User;

public interface EmailSender {
    void send(User user, String subject);
}

