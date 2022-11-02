package com.example.demo.controller;

import com.example.demo.domain.Entities.Quiz;
import com.example.demo.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping
    public List<Quiz> getQuizzes(){
        return quizService.getUsers();
    }
}
