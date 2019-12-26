package com.gerenciador.estacionamento.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gerenciador.estacionamento.model.Empresa;
import com.gerenciador.estacionamento.repository.EmpresaRepository;

public class AtualizacaoEmpresaForm {
	@NotEmpty @NotNull
	public String nome;
	@NotEmpty @NotNull
	public String CNPJ;
	@NotEmpty @NotNull
	public String endereco;
	@NotEmpty @NotNull
	public String telefone;
	@NotNull
	public int qtdVagasMotos;
	@NotNull
	public int qtdVagasCarros;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		CNPJ = CNPJ;
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

	public Empresa atualizar(Long id, EmpresaRepository empresaRepository) {
		Empresa empresa = empresaRepository.getOne(id);
		empresa.setNome(this.nome);
		
		empresa.setEndereco(this.endereco);
		empresa.setTelefone(this.telefone);
		empresa.setQtdVagasMotos(this.getQtdVagasMotos());
		empresa.setQtdVagasCarros(this.qtdVagasCarros);
		return empresa;

	}
}
