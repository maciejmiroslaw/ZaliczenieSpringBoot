package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getUsers();
    public void saveUser(User user);
    public User getUser(String username);
}
