package com.gerenciador.estacionamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gerenciador.estacionamento.controller.form.VeiculoForm;

@Entity
public class Veiculo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public String marca;
	public String modelo;
	public String cor;
	public String placa;
	public String tipo;
	
	public Veiculo() {}
	
	public Veiculo(VeiculoForm veiculoForm) {
		this.marca = veiculoForm.getMarca();
		this.modelo = veiculoForm.getModelo();
		this.cor = veiculoForm.getCor();
		this.placa = veiculoForm.getPlaca();
		this.tipo = veiculoForm.getTipo();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	
}
