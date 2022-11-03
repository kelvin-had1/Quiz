package com.example.demo.repository;

import com.example.demo.domain.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query("select * from Quiz where Name = :name")
    Object findByName(String name);
}
