package com.gerenciador.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.estacionamento.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	
}
