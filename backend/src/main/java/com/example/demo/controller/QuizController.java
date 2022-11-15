package com.example.demo.controller;

import com.example.demo.domain.Entities.Quiz;
import com.example.demo.domain.request.QuizRequest;
import com.example.demo.domain.response.ResponseMessage;
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
    public HttpEntity<ResponseMessage> createQuiz(@RequestBody QuizRequest quiz){
        if(quiz.getName().isEmpty()){
            var responseMessage = new ResponseMessage("Name is empty");           
            return ResponseEntity.status(400).body(responseMessage);
        }
        var response = quizService.createQuiz(quiz.getName());
        return response;
            
            

        


    }
}
