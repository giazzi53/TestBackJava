package com.santanderbr.testBackJava.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santanderbr.testBackJava.domain.ExpenseDomain;

@Repository
public interface ExpenseDAO extends MongoRepository<ExpenseDomain, String>{

	
}