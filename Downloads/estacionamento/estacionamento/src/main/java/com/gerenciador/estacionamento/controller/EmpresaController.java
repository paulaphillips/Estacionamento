package com.gerenciador.estacionamento.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gerenciador.estacionamento.controller.dto.EmpresaDto;
import com.gerenciador.estacionamento.controller.form.AtualizacaoEmpresaForm;
import com.gerenciador.estacionamento.controller.form.EmpresaForm;
import com.gerenciador.estacionamento.model.Empresa;
import com.gerenciador.estacionamento.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRep;
	
	@PostMapping
	@Transactional
	public ResponseEntity<EmpresaDto> cadastrar(@RequestBody @Valid EmpresaForm empresaForm, UriComponentsBuilder uriBuilder) {
		Empresa empresa = empresaForm.converter(empresaForm);
		empresaRep.save(empresa);
		URI uri = uriBuilder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
		return ResponseEntity.created(uri).body(new EmpresaDto(empresa));
	}
	
	@GetMapping("/{id}")
	public Optional<Empresa> listar(@PathVariable Long id) {
		Optional<Empresa> empresas = empresaRep.findById(id);
		return empresas;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Empresa> optional = empresaRep.findById(id);
		if (optional.isPresent()) {
			empresaRep.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EmpresaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEmpresaForm form) {
		Optional<Empresa> optional = empresaRep.findById(id);
		if (optional.isPresent()) {
			Empresa empresa = form.atualizar(id, empresaRep);
			return ResponseEntity.ok(new EmpresaDto(empresa));
		}
		return ResponseEntity.notFound().build();
	}
}
