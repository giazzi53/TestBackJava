package com.santanderbr.testBackJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santanderbr.testBackJava.domain.ExpenseDomain;
import com.santanderbr.testBackJava.service.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@PostMapping(value = "/addExpense")
	public String addExpense(@RequestBody ExpenseDomain expenseDomain) {
		
		expenseService.addExpense(expenseDomain);
		
		return "gasto adicionado";
	}
	
	@GetMapping(value = "/listExpenses")
	public List<ExpenseDomain> listExpenses(@RequestBody ExpenseDomain expenseDomain) {
		
		return expenseService.listExpenses(expenseDomain);
		
	}
	
	@GetMapping(value = "/listExpensesByDate")
	public List<ExpenseDomain> listExpensesByDate(@RequestBody ExpenseDomain expenseDomain) {
		
		return expenseService.listExpensesByData(expenseDomain);
		
	}
}