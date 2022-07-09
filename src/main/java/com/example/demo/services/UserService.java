package com.example.demo.services;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    public void saveUser(User user);
    User getUser(String username);
}
