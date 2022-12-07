package com.example.pagamentos.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.pagamentos.api.model.enumerador.StatusTransacao;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transacao")
public class Transacao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDateTime dataHora = LocalDateTime.now();
	
	private Double valor;
	
	private Integer numeroCartao;
	
	private String estabelecimento;
	
	@Transient
	private Map<String, String> descricao = new TreeMap<>();
	
	private StatusTransacao status;
	
	private String nsu;
	
    private Integer codigoAutorizacao;
	
	public Transacao() {
	}

	public Transacao(Integer id, Double valor, Integer numeroCartao, String estabelecimento, StatusTransacao status, String nsu,
			Integer codigoAutorizacao) {
		this.id = id;
		this.valor = valor;
		this.numeroCartao = numeroCartao;
		this.estabelecimento = estabelecimento;
		this.status = status;
		this.nsu = nsu;
		this.codigoAutorizacao = codigoAutorizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataHora() {
		String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";		
		return DateTimeFormatter.ofPattern(DATE_TIME_PATTERN).format(dataHora);
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}	

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNumeroCartao() {
		return numeroCartao.toString();
	}

	public void setNumeroCartao(Integer numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Map<String,String> getDescricao() {
		descricao.put("estabelecimento:", estabelecimento);
		descricao.put("dataHora:", getDataHora().toString());
		descricao.put("valor:", getValor().toString());
		descricao.put("nsu:", getNsu());
		descricao.put("status:", getStatus().toString());
		descricao.put("codigoAutorizacao:", getCodigoAutorizacao());
		return descricao;
	}

	public StatusTransacao getStatus() {
		return status;
	}

	public void setStatus(StatusTransacao status) {
		this.status = status;
	}
	
	public String getNsu() {
		return nsu;
	}

	public void setNsu(String nsu) {
		this.nsu = nsu;
	}

	public String getCodigoAutorizacao() {
		return codigoAutorizacao.toString();
	}

	public void setCodigoAutorizacao(Integer codigoAutorizacao) {
		this.codigoAutorizacao = codigoAutorizacao;
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
		Transacao other = (Transacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
