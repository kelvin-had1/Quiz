package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.ResponseMessage;
import com.example.demo.domain.Entities.User;
import com.example.demo.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping()
    public List<User> getUsers(){
        
        return userService.getUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseMessage> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }


}
