package com.santanderbr.testBackJava.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.mongodb.MongoException;
import com.santanderbr.testBackJava.DAO.ExpenseDAO;
import com.santanderbr.testBackJava.domain.ExpenseDomain;

public class ExpenseService {

	@Autowired
	private ExpenseDAO expenseDAO;
	
	private Logger LOGGER = LogManager.getLogger(ExpenseService.class);

	public void addExpense(@RequestBody ExpenseDomain expenseDomain) {
		if (expenseDomain.getDescricao().trim().isEmpty()) {
			// checks whether the description is valid
			LOGGER.error("A descrição não pode ser vazia");
			throw new IllegalArgumentException("A descrição não pode ser vazia");
		}

		if (expenseDomain.getValor() <= 0) {
			// checks whether the value is valid
			LOGGER.error("O valor da despesa deve ser maior do que zero");
			throw new IllegalArgumentException("O valor da despesa deve ser maior do que zero");
		}
		
		if (expenseDomain.getCodigousuario() <= 0) {
			// checks whether the customer code is valid
			LOGGER.error("Código do usuário deve ser maior do que zero");
			throw new IllegalArgumentException("Código do usuário deve ser maior do que zero");
		}

		try {
			expenseDAO.insert(expenseDomain);
		} catch(Exception e) {
			LOGGER.error("Ocorreu um erro ao se comunicar com o MongoDB");
			throw new MongoException("Ocorreu um erro ao se comunicar com o MongoDB");
		}
	}

	public List<ExpenseDomain> listExpenses(@RequestBody ExpenseDomain expenseDomain) {
		return expenseDAO.findByCodigousuario(expenseDomain.getCodigousuario());
	}

	public List<ExpenseDomain> listExpensesByData(@RequestBody ExpenseDomain expenseDomain) {
		return expenseDAO.findByData(expenseDomain.getData());
	}

	public void addCategory(@RequestBody ExpenseDomain expenseDomain) {
		if (expenseDomain.getCategoria().trim().isEmpty()) {
			// checks whether the new category is empty
			LOGGER.error("A categoria não pode ser vazia");
			throw new IllegalArgumentException("A categoria não pode ser vazia");
		}

		ExpenseDomain queryDomain = expenseDAO.findById(expenseDomain.getExpenseId()).get();

		if (queryDomain.getCategoria() != null) {
			// checks whether the current category is already filled
			LOGGER.error("Gasto já possui categoria");
			throw new IllegalArgumentException("Gasto já possui categoria");
		}

		queryDomain.setCategoria(expenseDomain.getCategoria());

		try {
			expenseDAO.save(queryDomain);
		} catch(Exception e) {
			LOGGER.error("Ocorreu um erro ao se comunicar com o MongoDB");
			throw new MongoException("Ocorreu um erro ao se comunicar com o MongoDB");
		}
	}
}