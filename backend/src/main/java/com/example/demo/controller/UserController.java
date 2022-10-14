package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Entities.User;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @GetMapping()
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        User user1 = new User("Kelvin Mendes", "576048f388", "kelvinmendes970@gmail.com");

        users.add(user1);
        return users;
    }


}
