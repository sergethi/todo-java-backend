package com.sergecoder.taskmananger.controller;

import com.sergecoder.taskmananger.model.User;
import com.sergecoder.taskmananger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "You added a new User";
    }

    @GetMapping("/getUsers")
    public List<User> getAllUsers(){return userService.getAllUser();}
}
