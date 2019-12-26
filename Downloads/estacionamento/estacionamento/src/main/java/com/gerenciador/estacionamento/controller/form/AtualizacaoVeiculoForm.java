package com.gerenciador.estacionamento.controller.form;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gerenciador.estacionamento.model.Empresa;
import com.gerenciador.estacionamento.model.Veiculo;
import com.gerenciador.estacionamento.repository.EmpresaRepository;
import com.gerenciador.estacionamento.repository.VeiculoRepository;

public class AtualizacaoVeiculoForm {
	@NotEmpty @NotNull 
	public String marca;
	@NotEmpty @NotNull
	public String modelo;
	@NotEmpty @NotNull
	public String cor;
	@NotEmpty @NotNull
	public String placa;
	@NotEmpty @NotNull
	public String tipo;
		
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Veiculo atualizar(Long id, VeiculoRepository veiculoRepository) {
		Veiculo veiculo = veiculoRepository.getOne(id);
		veiculo.setMarca(this.marca);
		veiculo.setModelo(this.modelo);
		veiculo.setCor(this.cor);
		veiculo.setPlaca(this.placa);
		veiculo.setTipo(this.tipo);
		return veiculo;

	}
}
