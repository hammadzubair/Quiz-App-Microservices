package com.devrezaur.main.controller;

import java.util.List;

import com.devrezaur.main.bean.ResultView;
import com.devrezaur.main.feignclient.QuestionsFeignClient;
import com.devrezaur.main.feignclient.ResultFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.devrezaur.main.bean.QuestionForm;
import com.devrezaur.main.service.QuizService;

@Controller
public class MainController {

	private final QuestionsFeignClient questionsFeignClient;
	private final ResultFeignClient resultFeignClient;

	public MainController(QuestionsFeignClient questionsFeignClient, ResultFeignClient resultFeignClient, ResultView resultView) {
		this.questionsFeignClient = questionsFeignClient;
		this.resultFeignClient = resultFeignClient;
		this.resultView = resultView;
	}

	@Autowired
	QuizService qService;

	Boolean submitted = false;


	private final ResultView resultView;

	@ModelAttribute("resultView")
	public ResultView getResult() {
		return resultView;
	}

	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	@PostMapping("/quiz")
	public String quiz(@RequestParam String username, Model m, RedirectAttributes ra) {
		if(username.equals("")) {
			ra.addFlashAttribute("warning", "You must enter your name");
			return "redirect:/";
		}
		submitted = false;
		resultFeignClient.saveUserName(username);  // call result Microservice using FeignClient
		resultView.setUsername(username);
		ResponseEntity<QuestionForm> res = questionsFeignClient.getAllQuestions();   //  call questions Microservice using FeignClient
		QuestionForm qForm = res.getBody();
		m.addAttribute("qForm", qForm);
		return "quiz.html";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm, Model m) {
		if(!submitted) {

			resultFeignClient.saveTotalCorrect(qService.getResult(qForm)); // call result Microservice using FeignClient
			resultView.setTotalCorrect(qService.getResult(qForm));
			resultFeignClient.saveScore(); // call result Microservice using FeignClient
			submitted = true;

		}
		return "result.html";
	}
	
	@GetMapping("/score")
	public String score(Model m) {
		ResponseEntity<List<ResultView>> res = resultFeignClient.getTopScore();  // call result Microservice using FeignClient
		List<ResultView> sList = res.getBody();
		m.addAttribute("sList", sList);
		return "scoreboard.html";
	}

}
