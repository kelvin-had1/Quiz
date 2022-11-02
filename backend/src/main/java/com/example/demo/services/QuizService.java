package com.example.demo.services;

import com.example.demo.domain.Entities.Quiz;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;


    public List<Quiz> getUsers(){
        return quizRepository.findAll();
    }
}
