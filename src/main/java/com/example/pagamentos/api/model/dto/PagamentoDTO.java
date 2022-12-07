package com.example.pagamentos.api.model.dto;

import java.io.Serializable;

import com.example.pagamentos.api.model.FormaPagamento;
import com.example.pagamentos.api.model.Pagamento;
import com.example.pagamentos.api.model.Transacao;

public class PagamentoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	    
	private Transacao transacao;
	
	private FormaPagamento formaPagamento;
	
	public PagamentoDTO(Pagamento obj) {
		this.id = obj.getId();
		this.transacao = obj.getTransacao();
		this.formaPagamento = obj.getFormaPagamento();
	}
	
	public PagamentoDTO() {
		super();
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
}
