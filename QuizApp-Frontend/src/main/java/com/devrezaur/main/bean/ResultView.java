package com.devrezaur.main.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ResultView  implements Serializable {

	private int id;
	private String username;
	private int totalCorrect = 0;

}
