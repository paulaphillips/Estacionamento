package com.gerenciador.estacionamento.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gerenciador.estacionamento.controller.dto.VeiculoDto;
import com.gerenciador.estacionamento.controller.form.AtualizacaoVeiculoForm;
import com.gerenciador.estacionamento.controller.form.VeiculoForm;
import com.gerenciador.estacionamento.model.Veiculo;
import com.gerenciador.estacionamento.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRep;
	
	@GetMapping("/{id}")
	public Optional<Veiculo> listar(@PathVariable Long id) {
		Optional<Veiculo> veiculos = veiculoRep.findById(id);
		return veiculos;
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Veiculo> optional = veiculoRep.findById(id);
		if (optional.isPresent()) {
			veiculoRep.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VeiculoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoVeiculoForm form) {
		Optional<Veiculo> optional = veiculoRep.findById(id);
		if (optional.isPresent()) {
			Veiculo veiculo = form.atualizar(id, veiculoRep);
			return ResponseEntity.ok(new VeiculoDto(veiculo));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<VeiculoDto> cadastrar(@RequestBody @Valid VeiculoForm veiculoForm, UriComponentsBuilder uriBuilder) {
		Veiculo veiculo = veiculoForm.converter(veiculoForm);
		veiculoRep.save(veiculo);
		URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
	}
}
