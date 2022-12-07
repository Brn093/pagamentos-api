package com.example.pagamentos.api.model.dto;

import java.io.Serializable;
import java.util.Map;

import com.example.pagamentos.api.model.Pagamento;
import com.example.pagamentos.api.model.Transacao;
import com.example.pagamentos.api.model.enumerador.StatusTransacao;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TransacaoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private String dataHora;
	
	private String numeroCartao;
	
	private String estabelecimento;
	
	private Map<String, String> descricao;
	
	private StatusTransacao status;
	
	private Pagamento pagamento;
	
	public TransacaoDTO(Transacao obj) {
		this.id = obj.getId();
		this.dataHora = obj.getDataHora();
		this.numeroCartao = obj.getNumeroCartao();
		this.status = obj.getStatus();
		this.estabelecimento = obj.getEstabelecimento();
	}
	
	public TransacaoDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	
	public String getNumeroCartao() {
		return numeroCartao.toString();
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setDescricao(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public StatusTransacao getStatus() {
		return status;
	}

	public void setStatus(StatusTransacao status) {
		this.status = status;
	}

	public Map<String, String> getDescricao() {
		return descricao;
	}

	public void setDescricao(Map<String, String> descricao) {
		this.descricao = descricao;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
}
