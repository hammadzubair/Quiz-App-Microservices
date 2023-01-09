package com.devrezaur.main.feignclient;

import com.devrezaur.main.bean.ResultView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "resultService", url = "${result.url}")
public interface ResultFeignClient {

    @PostMapping("/result-call/save-user-name")
    public void saveUserName(@RequestParam String username);

    @PostMapping("/result-call/save-tot-correct")
    public void saveTotalCorrect(@RequestParam int totCorrect);

    @PostMapping("/result-call/save-score")
    public void saveScore();

    @GetMapping("/result-call/tope-score")
    public ResponseEntity<List<ResultView>> getTopScore();

}
