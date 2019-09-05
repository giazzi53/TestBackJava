package com.santanderbr.testBackJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.santanderbr.testBackJava.service.ExpenseService;

@SpringBootApplication
public class TestBackJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBackJavaApplication.class, args);
	}
	
	@Bean
	public ExpenseService expenseService() {
		return new ExpenseService();
	}

}
