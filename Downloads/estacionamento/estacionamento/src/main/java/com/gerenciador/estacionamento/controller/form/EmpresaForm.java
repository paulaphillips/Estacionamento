package com.gerenciador.estacionamento.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gerenciador.estacionamento.model.Empresa;

public class EmpresaForm {

	@NotEmpty @NotNull
	public String nome;
	@NotEmpty @NotNull
	public String cnpj;
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
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereço(String endereco) {
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
	public Empresa converter(EmpresaForm empresaForm) {
		return new Empresa(empresaForm);
	}
}
