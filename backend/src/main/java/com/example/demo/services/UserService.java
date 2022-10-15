package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.domain.ResponseMessage;
import com.example.demo.domain.Entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository _userRepository;

    public List<User> getUsers(){

        return _userRepository.findAll();
    }

    public ResponseEntity<ResponseMessage> createUser(User user){
        User newUser = user;

        ResponseMessage responseMessage = new ResponseMessage();

        if(_userRepository.findByemail(newUser.getEmail()) != null){
            responseMessage.setMessage("This email has already been registered.");
            
            return ResponseEntity.status(403).body(responseMessage);
        }

        responseMessage.setMessage("User created");

        _userRepository.save(newUser);
        return ResponseEntity.ok().body(responseMessage);

    }

    

    public Optional<User> getUser(long id){
        Optional<User> user = _userRepository.findById(id);
        
        return user;
    }
}
