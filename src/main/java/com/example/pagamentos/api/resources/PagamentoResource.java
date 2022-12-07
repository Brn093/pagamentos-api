package com.example.pagamentos.api.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagamentos.api.model.Pagamento;
import com.example.pagamentos.api.model.dto.PagamentoDTO;
import com.example.pagamentos.api.services.PagamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/pagamentos")
@Api(value = "API REST Pagamentos")
@CrossOrigin(origins="*")
public class PagamentoResource {
	
	@Autowired
	private PagamentoService service;
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Retorna um pagamento")
	public ResponseEntity<PagamentoDTO> findById(@PathVariable Integer id) {
		Pagamento obj = service.findById(id);
		return ResponseEntity.ok().body(new PagamentoDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Deleta um pagamento")
	public ResponseEntity<PagamentoDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PagamentoDTO> update(@PathVariable Integer id, @Valid @RequestBody PagamentoDTO objDTO) {
		Pagamento obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new PagamentoDTO(obj));
	}
}
