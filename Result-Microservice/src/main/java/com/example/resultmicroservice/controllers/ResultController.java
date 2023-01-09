package com.example.resultmicroservice.controllers;

import com.example.resultmicroservice.models.Result;
import com.example.resultmicroservice.services.ResultService;
import com.example.resultmicroservice.uri.URIs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = URIs.BASE)
public class ResultController {

    @Autowired
    Result result;
    @ModelAttribute("result")
    public Result getResult() {
        return result;
    }

   private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping(value = URIs.SAVEUSER, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveUserName(@RequestParam String username) {
        result.setUsername(username);
    }


    @PostMapping(value = URIs.SAVETOTCORRECT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveTotCorrect(@RequestParam int totCorrect) {
        result.setTotalCorrect(totCorrect);
    }


    @PostMapping(value = URIs.SAVESCORE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveScore() {
        resultService.saveScore(result);
    }

    @GetMapping(value = URIs.TOPESCORE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Result>> getTopScore() {
        return ResponseEntity.ok(resultService.getTopScore());

    }

}
