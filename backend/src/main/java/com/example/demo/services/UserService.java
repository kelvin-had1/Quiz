package com.example.demo.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.domain.response.ResponseMessage;
import com.example.demo.domain.Entities.User;
import com.example.demo.repository.UserRepository;

import io.jsonwebtoken.Jwts;

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

    public ResponseEntity<ResponseMessage> updateUser(User user){
        ResponseMessage responseMessage = new ResponseMessage();

        User userToUpdate = user;
        if(_userRepository.findById(userToUpdate.getId()) != null){

            _userRepository.save(userToUpdate);
            responseMessage.setMessage("User has updated");
            return ResponseEntity.ok().body(responseMessage);
            
        }

        responseMessage.setMessage("User not found");
        return ResponseEntity.status(404).body(responseMessage);


    }
    
    public ResponseEntity<ResponseMessage> login(String email, String password){
        
        ResponseMessage responseMessage = new ResponseMessage();

        boolean hasUser = false;
        if(_userRepository.findByemail(email) != null && _userRepository.findBypassword(password) != null){
            hasUser = true;
        }
        

        if(hasUser == true){
            String jwtToken = Jwts.builder()
                    .claim("email", email)                    
                    .setSubject(email)
                    .setIssuer("localhost:8080")
                    .setIssuedAt(new Date())
                    .setExpiration(
						Date.from(
							LocalDateTime.now().plusMinutes(15L)
								.atZone(ZoneId.systemDefault())
							.toInstant()))
                    .compact();
                responseMessage.setMessage(jwtToken);
                return ResponseEntity.status(200).body(responseMessage);            
        }

        responseMessage.setMessage("Email or password is incorrect.");
        return ResponseEntity.status(401).body(responseMessage);


        
    }

    public Optional<User> getUser(long id){
        Optional<User> user = _userRepository.findById(id);
        
        return user;
    }
}
