package com.example.demo.services;

import com.example.demo.domain.Entities.Quiz;
import com.example.demo.domain.response.ResponseMessage;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;


    public List<Quiz> getUsers(){
        return quizRepository.findAll();
    }

    public HttpEntity<ResponseMessage> createQuiz(String name) {        
        var response = new ResponseMessage();
        Quiz quiz = new Quiz();
        quiz.setName(name);

        if(quizRepository.findByname(name) != null){
            response.setMessage("Quiz already exists");
            return ResponseEntity.status(400).body(response);

        }

        quizRepository.save(quiz);

        response.setMessage("Quiz created");
        return ResponseEntity.status(201).body(response);
    }
}
