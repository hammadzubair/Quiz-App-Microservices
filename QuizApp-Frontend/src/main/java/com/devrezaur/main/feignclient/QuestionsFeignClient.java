package com.devrezaur.main.feignclient;

import com.devrezaur.main.bean.QuestionForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "questionService", url = "${question.url}")
public interface QuestionsFeignClient {

    @GetMapping("/questions-call/get-all-questions")
    public ResponseEntity<QuestionForm> getAllQuestions();

}
