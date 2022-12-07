package com.example.pagamentos.api.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pagamentos.api.model.FormaPagamento;
import com.example.pagamentos.api.model.Pagamento;
import com.example.pagamentos.api.model.Transacao;
import com.example.pagamentos.api.model.enumerador.StatusPagamento;
import com.example.pagamentos.api.model.enumerador.StatusTransacao;
import com.example.pagamentos.api.repository.PagamentoRepository;
import com.example.pagamentos.api.repository.TransacaoRepository;

@Service
public class DBService {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public void instanciaDB() {
		Transacao transacao1 = new Transacao(null, 1000.0, 1234, "PetShop Mundo cão", StatusTransacao.AUTORIZADO, "1234567890", 147258369);
		FormaPagamento formaPagamento1 = new FormaPagamento(StatusPagamento.AVISTA, 10);
		Pagamento pag1 = new Pagamento(null, transacao1, formaPagamento1);
		
		pagamentoRepository.saveAll(Arrays.asList(pag1));
		transacaoRepository.saveAll(Arrays.asList(transacao1));
	}
}
