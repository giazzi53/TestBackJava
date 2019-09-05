package com.santanderbr.testBackJava.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santanderbr.testBackJava.domain.ExpenseDomain;

@Repository
public interface ExpenseDAO extends MongoRepository<ExpenseDomain, String>{

	public List<ExpenseDomain> findByCodigousuario(int codigousuario);
	
	public List<ExpenseDomain> findByData(Date data);
	
}