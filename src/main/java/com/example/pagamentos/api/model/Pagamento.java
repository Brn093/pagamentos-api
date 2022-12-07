package com.example.pagamentos.api.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.pagamentos.api.model.dto.PagamentoDTO;

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transacao_id", referencedColumnName = "id")
	private Transacao transacao;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forma_pagamento_id", referencedColumnName = "statusPagamento")
    private FormaPagamento formaPagamento;
    
	public Pagamento() {		
	}

	public Pagamento(Integer id, Transacao transacao, FormaPagamento formaPagamento) {
		this.id = id;
		this.transacao = transacao;
		this.formaPagamento = formaPagamento;
	}
	
	public Pagamento(PagamentoDTO obj) {
		this.id = obj.getId();
		this.transacao = obj.getTransacao();
		this.formaPagamento = obj.getFormaPagamento();		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
