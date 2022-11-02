package com.example.demo.repository;

import com.example.demo.domain.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository  extends JpaRepository<Quiz, Long> {

}
