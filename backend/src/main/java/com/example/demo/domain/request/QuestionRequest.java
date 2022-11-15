package com.example.demo.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class QuestionRequest {

    private String name;

    private String firstAnswer;

    private String secondAnswer;

    private String thirdAnswer;

    private String fourthAnswer;

    private String correctAnswer;
}
