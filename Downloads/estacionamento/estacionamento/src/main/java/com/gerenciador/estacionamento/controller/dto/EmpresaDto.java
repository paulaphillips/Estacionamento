package com.gerenciador.estacionamento.controller.dto;

import com.gerenciador.estacionamento.model.Empresa;

public class EmpresaDto {
	public Long id;
	public String nome;
	public String CNPJ;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
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

	public EmpresaDto(Empresa empresa) {
		this.id = empresa.getId();
		this.nome = empresa.getNome();
		
		this.endereco = empresa.getEndereco();
		this.telefone = empresa.getTelefone();
		this.qtdVagasMotos = empresa.getQtdVagasMotos();
		this.qtdVagasCarros = empresa.getQtdVagasCarros();
	}

//	public static List<EmpresaDto> converter(List<Empresa> empresas) {
//		return empresas.stream().map(EmpresaDto::new).collect(Collectors.toList());
//	}
}
