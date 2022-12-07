package com.example.pagamentos.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.pagamentos.api.model.enumerador.StatusPagamento;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id	
	private StatusPagamento statusPagamento;
	private Integer numeroDeParcelas;
	
	public FormaPagamento() {
	}

	public FormaPagamento(StatusPagamento statusPagamento, Integer numeroDeParcelas) {
		this.statusPagamento = statusPagamento;
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento.AVISTA;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public String getNumeroDeParcelas() {
		return numeroDeParcelas.toString();
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}	
}
