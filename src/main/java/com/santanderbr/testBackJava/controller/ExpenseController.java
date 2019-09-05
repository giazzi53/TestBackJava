package com.santanderbr.testBackJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.santanderbr.testBackJava.domain.ExpenseDomain;
import com.santanderbr.testBackJava.service.ExpenseService;

public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@PostMapping(value = "/addExpense")
	public String addExpense(@RequestBody ExpenseDomain expenseDomain) {
		
		expenseService.addExpense(expenseDomain);
		
		return "gasto adicionado";
	}
}