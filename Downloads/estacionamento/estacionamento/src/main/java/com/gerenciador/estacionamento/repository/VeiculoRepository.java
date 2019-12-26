package com.gerenciador.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.estacionamento.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

}
