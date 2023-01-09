package com.devrezaur.main.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionView implements Serializable {

	private int quesId;
	private String title;
	private String optionA;
	private String optionB;
	private String optionC;
	private int ans;
	private int chose;

}
