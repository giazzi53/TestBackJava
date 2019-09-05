package com.santanderbr.testBackJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.santanderbr.testBackJava.DAO.ExpenseDAO;
import com.santanderbr.testBackJava.domain.ExpenseDomain;

public class ExpenseService{
	
	@Autowired
	ExpenseDAO expenseDAO;
	
	public void addExpense(@RequestBody ExpenseDomain expenseDomain) {
		
		 expenseDAO.insert(expenseDomain);
		 
	}
}