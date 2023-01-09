package com.devrezaur.main.service;
import com.devrezaur.main.bean.QuestionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devrezaur.main.bean.QuestionForm;

@Service
public class QuizService {

	@Autowired
	QuestionForm qForm;

	public int getResult(QuestionForm qForm) {
		int correct = 0;
		
		for(QuestionView q: qForm.getQuestions())
			if(q.getAns() == q.getChose())
				correct++;
		
		return correct;
	}
}
