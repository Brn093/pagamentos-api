package com.example.pagamentos.api.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pagamentos.api.exception.ObjectNotFoundException;
import com.example.pagamentos.api.model.Pagamento;
import com.example.pagamentos.api.model.Transacao;
import com.example.pagamentos.api.model.dto.PagamentoDTO;
import com.example.pagamentos.api.repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository repository;
	
	public Pagamento findById(Integer id) {
		Optional<Pagamento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id));
	}
	
	public void delete(Integer id) {
		Pagamento obj = findById(id);		
		repository.deleteById(id);		
	}
	
	public Pagamento update(Integer id, @Valid PagamentoDTO objDTO) {
		objDTO.setId(id);
		Pagamento objAntigo = findById(id);
		objAntigo = newPagamento(objDTO);
		
		return repository.save(objAntigo);
	}
	
	private Pagamento newPagamento(PagamentoDTO obj) {
		
		Pagamento pagamento = new Pagamento();		
		
		pagamento.setId(obj.getId());
		pagamento.setTransacao(obj.getTransacao());
		pagamento.setFormaPagamento(obj.getFormaPagamento());
		
		return pagamento;
	}
}
