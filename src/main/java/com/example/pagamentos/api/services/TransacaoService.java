package com.example.pagamentos.api.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pagamentos.api.exception.ObjectNotFoundException;
import com.example.pagamentos.api.model.Transacao;
import com.example.pagamentos.api.repository.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private TransacaoRepository repository;
	
	public Transacao findById(Integer id) {
		Optional<Transacao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id));
	}
}
