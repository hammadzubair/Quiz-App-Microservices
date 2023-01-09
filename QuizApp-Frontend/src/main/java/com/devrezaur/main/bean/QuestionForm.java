package com.devrezaur.main.bean;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class QuestionForm {

	private List<QuestionView> questions;
	
	public List<QuestionView> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<QuestionView> questions) {
		this.questions = questions;
	}
}
