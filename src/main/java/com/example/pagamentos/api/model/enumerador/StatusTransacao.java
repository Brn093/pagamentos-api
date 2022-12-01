package com.example.pagamentos.api.model.enumerador;

public enum StatusTransacao {
	AUTORIZADO(0, "AUTORIZADO"),
	NEGADO(1, "NEGADO");
	
	private Integer id;
	private String descricao;
	
	private StatusTransacao(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	private static StatusTransacao toEnum(Integer id) {
		if(id == null) {
			return null;
		}
		
		for(StatusTransacao x : StatusTransacao.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("StatusPagamento inválido");
	}
}
