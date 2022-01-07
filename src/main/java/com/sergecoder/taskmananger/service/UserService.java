package com.sergecoder.taskmananger.service;

import com.sergecoder.taskmananger.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUser();
}
