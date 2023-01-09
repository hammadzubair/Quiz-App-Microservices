package com.devrezaur.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class SpringBootQuizAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootQuizAppApplication.class, args);
	}

}
