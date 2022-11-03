package com.example.demo.controller;

import com.example.demo.domain.Entities.Quiz;
import com.example.demo.domain.request.QuizRequest;
import com.example.demo.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public HttpEntity<Quiz> createQuiz(final @RequestBody QuizRequest quiz){
        if(quiz.getName().isEmpty())
            return ResponseEntity.status(400).build();

        return quizService.createQuiz(quiz.getName());


    }
}
