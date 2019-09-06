package com.santanderbr.testBackJava.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ExpenseCollection")
public class ExpenseDomain {
	
	@Id
	private String expenseId;
	
	private String descricao;
	
	private double valor;
	
	private int codigousuario;
	
	private Date data;
	
	private String categoria;

	public ExpenseDomain() {
		
	}
	
	public String getExpenseId() {
		return expenseId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCodigousuario() {
		return codigousuario;
	}

	public void setCodigousuario(int codigousuario) {
		this.codigousuario = codigousuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
