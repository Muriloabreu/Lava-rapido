package com.app.lavarapido.services;

import java.util.List;
import java.util.Optional;


import com.app.lavarapido.models.VeiculoModel;

public interface VeiculoService {

	List<VeiculoModel> findAll();
	Optional<VeiculoModel> findById(Long id);
	VeiculoModel save(VeiculoModel veiculo);
	void delete(VeiculoModel veiculo);
	boolean existsByPlaca(String placa);
}
