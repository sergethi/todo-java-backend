package com.sergecoder.taskmananger.service;

import com.sergecoder.taskmananger.model.User;
import com.sergecoder.taskmananger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {return userRepository.save(user);}

    @Override
    public List<User> getAllUser() {return userRepository.findAll();}
}
