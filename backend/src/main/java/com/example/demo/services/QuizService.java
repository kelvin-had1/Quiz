package com.example.demo.services;

import com.example.demo.domain.Entities.Questions;
import com.example.demo.domain.Entities.Quiz;
import com.example.demo.domain.request.QuestionRequest;
import com.example.demo.domain.response.ResponseMessage;
import com.example.demo.repository.QuestionsRepository;
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

    @Autowired
    QuestionsRepository questionsRepository;
    
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

    public HttpEntity<ResponseMessage> saveQuestions(Long id, List<QuestionRequest> questions) {
        var response = new ResponseMessage();

        if(quizRepository.findById(id) == null){
            response.setMessage("Quiz does not exist");
            return ResponseEntity.status(400).body(response);
        }

        Quiz quiz = quizRepository.findById(id).get();

        for (QuestionRequest question : questions) {
            var questionEntity = new Questions();
            questionEntity.setQuiz(quiz);
            questionEntity.setName(question.getName());
            questionEntity.setFirstAnswer(question.getFirstAnswer());
            questionEntity.setSecondAnswer(question.getSecondAnswer());
            questionEntity.setThirdAnswer(question.getThirdAnswer());
            questionEntity.setFourthAnswer(question.getFourthAnswer());
            questionEntity.setCorrectAnswer(question.getCorrectAnswer());

            questionsRepository.save(questionEntity);
        }

        response.setMessage("Questions saved");
        return ResponseEntity.status(201).body(response);
        
    }
}
