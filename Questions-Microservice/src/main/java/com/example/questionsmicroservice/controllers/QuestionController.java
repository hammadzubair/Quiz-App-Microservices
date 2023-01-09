package com.example.questionsmicroservice.controllers;

import com.example.questionsmicroservice.components.QuestionForm;
import com.example.questionsmicroservice.services.QuestionsService;
import com.example.questionsmicroservice.uri.URIs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = URIs.BASE)
public class QuestionController {

    @Autowired
    QuestionsService qService;

    @GetMapping(value = URIs.ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionForm> getAllQuestions() {
        return ResponseEntity.ok(qService.getQuestions());
    }



}
