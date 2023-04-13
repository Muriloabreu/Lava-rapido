package com.app.lavarapido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.lavarapido.models.VeiculoModel;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long>{

	boolean existsByPlaca (VeiculoModel veiculo);
}
