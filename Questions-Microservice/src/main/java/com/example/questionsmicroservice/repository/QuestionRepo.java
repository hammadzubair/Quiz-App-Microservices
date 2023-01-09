package com.example.questionsmicroservice.repository;

import com.example.questionsmicroservice.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
}