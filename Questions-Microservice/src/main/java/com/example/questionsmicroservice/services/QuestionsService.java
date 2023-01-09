package com.example.questionsmicroservice.services;
import com.example.questionsmicroservice.components.QuestionForm;
import com.example.questionsmicroservice.models.Question;
import com.example.questionsmicroservice.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class QuestionsService {
	
	@Autowired
	Question question;
	@Autowired
	QuestionForm qForm;
	@Autowired
	QuestionRepo qRepo;

	
	public QuestionForm getQuestions() {
		List<Question> allQues = qRepo.findAll();
		List<Question> qList = new ArrayList<Question>();
		
		Random random = new Random();
		
		for(int i=0; i<5; i++) {
			int rand = random.nextInt(allQues.size());
			qList.add(allQues.get(rand));
			allQues.remove(rand);
		}

		qForm.setQuestions(qList);
		
		return qForm;
	}
}
