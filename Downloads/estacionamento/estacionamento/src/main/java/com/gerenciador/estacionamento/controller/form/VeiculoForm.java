package com.gerenciador.estacionamento.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gerenciador.estacionamento.model.Veiculo;

public class VeiculoForm {
	@NotNull @NotEmpty
	public String marca;
	@NotNull @NotEmpty
	public String modelo;
	@NotNull @NotEmpty
	public String cor;
	@NotNull @NotEmpty
	public String placa;
	@NotNull @NotEmpty
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
	public Veiculo converter(VeiculoForm veiculoForm) {
		return new Veiculo(veiculoForm);
	}
	
}
