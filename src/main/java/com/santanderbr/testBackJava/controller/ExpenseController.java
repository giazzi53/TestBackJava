package com.santanderbr.testBackJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mongodb.MongoException;
import com.santanderbr.testBackJava.domain.ExpenseDomain;
import com.santanderbr.testBackJava.service.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@PostMapping(value = "/addExpense")
	public ResponseEntity<String> addExpense(@RequestBody ExpenseDomain expenseDomain) {
		try {
			expenseService.addExpense(expenseDomain);
		} catch(IllegalArgumentException i) {
			return new ResponseEntity<>(i.getMessage(), HttpStatus.BAD_REQUEST);
		} catch(MongoException u) {
			return new ResponseEntity<>(u.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("Gasto adicionado", HttpStatus.OK);
	}

	@GetMapping(value = "/listExpenses")
	public List<ExpenseDomain> listExpenses(@RequestBody ExpenseDomain expenseDomain) {

		return expenseService.listExpenses(expenseDomain);

	}

	@GetMapping(value = "/listExpensesByDate")
	public List<ExpenseDomain> listExpensesByDate(@RequestBody ExpenseDomain expenseDomain) {

		return expenseService.listExpensesByData(expenseDomain);

	}

	@PutMapping(value = "/addCategory")
	public ResponseEntity<String> addCategory(@RequestBody ExpenseDomain expenseDomain) {
		try {
			expenseService.addCategory(expenseDomain);
		} catch(IllegalArgumentException i) {
			return new ResponseEntity<>(i.getMessage(), HttpStatus.BAD_REQUEST);
		} catch(MongoException u) {
			return new ResponseEntity<>(u.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("Categoria adicionada", HttpStatus.OK);
	}
}