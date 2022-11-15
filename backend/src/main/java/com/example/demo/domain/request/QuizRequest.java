package com.example.demo.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuizRequest {

    private String name;

    @Override
    public String toString() {
        return "QuizRequest{" +
                "Name='" + name + '\'' +
                '}';
    }

}
