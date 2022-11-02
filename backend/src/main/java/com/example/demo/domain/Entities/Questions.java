package com.example.demo.domain.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Questions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "firstAnswer")
    private String FirstAnswer;

    @Column(name = "secondAnswer")
    private String SecondAnswer;

    @Column(name = "thirdAnswer")
    private String ThirdAnswer;

    @Column(name = "fourthAnswer")
    private String FourthAnswer;

    @Column(name = "correctAnswer")
    private String CorrectAnswer;

    @ManyToOne
    private Quiz Quiz;

}
