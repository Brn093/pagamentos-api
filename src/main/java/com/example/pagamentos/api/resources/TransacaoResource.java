package com.example.pagamentos.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagamentos.api.model.Transacao;
import com.example.pagamentos.api.model.dto.TransacaoDTO;
import com.example.pagamentos.api.services.TransacaoService;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoResource {
	
	@Autowired
	private TransacaoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TransacaoDTO> findById(@PathVariable Integer id) {
		Transacao obj = service.findById(id);
		return ResponseEntity.ok().body(new TransacaoDTO(obj));
	}
}
