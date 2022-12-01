package com.example.pagamentos.api.model.enumerador;

public enum StatusPagamento {
	AVISTA(0, "AVISTA"),
	PARCELADOLOJA(1, "PARCELADO LOJA"),
	PARCELADOEMISSOR(2, "PARCELADO EMISSOR");
	
	private Integer id;
	private String descricao;
	
	private StatusPagamento(Integer id, String descricao) {
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
	
	private static StatusPagamento toEnum(Integer id) {
		if(id == null) {
			return null;
		}
		
		for(StatusPagamento x : StatusPagamento.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("StatusPagamento inválido");
	}
}
