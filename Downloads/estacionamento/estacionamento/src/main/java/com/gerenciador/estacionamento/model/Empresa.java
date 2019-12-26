package com.gerenciador.estacionamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

import com.gerenciador.estacionamento.controller.form.EmpresaForm;
import com.gerenciador.estacionamento.repository.EmpresaRepository;

@Entity
public class Empresa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public String nome;
	public String cnpj;
	public String endereco;
	public String telefone;
	public int qtdVagasMotos;
	public int qtdVagasCarros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getQtdVagasMotos() {
		return qtdVagasMotos;
	}

	public void setQtdVagasMotos(int qtdVagasMotos) {
		this.qtdVagasMotos = qtdVagasMotos;
	}

	public int getQtdVagasCarros() {
		return qtdVagasCarros;
	}

	public void setQtdVagasCarros(int qtdVagasCarros) {
		this.qtdVagasCarros = qtdVagasCarros;
	}

	public Empresa() {

	}

	public Empresa(@Valid EmpresaForm empresaForm) {
		this.nome = empresaForm.nome;
		this.cnpj = empresaForm.cnpj;
		this.endereco = empresaForm.endereco;
		this.telefone = empresaForm.telefone;
		this.qtdVagasMotos = empresaForm.qtdVagasMotos;
		this.qtdVagasCarros = empresaForm.qtdVagasCarros;
	}

}
