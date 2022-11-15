package com.example.demo.services;

import com.example.demo.domain.Entities.Quiz;
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

    public HttpEntity<Quiz> createQuiz(String name) {
        var quiz = new Quiz();
        quiz.setName(name);

        if(quizRepository.findByname(name) != null)
            return ResponseEntity.status(400).build();

        quizRepository.save(quiz);


        return ResponseEntity.status(201).build();
    }
}
