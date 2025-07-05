package com.nisum.demo.repository;



import com.nisum.demo.model.User;

public interface UserRepository {
    User findById(Long id);
}

