package com.app.lavarapido.services;

import java.util.List;
import java.util.Optional;

import com.app.lavarapido.models.ConsumoModel;


public interface ConsumoService {
	
	List<ConsumoModel> findAll();
	Optional<ConsumoModel> findById(Long id);
	ConsumoModel save(ConsumoModel consumo);
	void delete(ConsumoModel consumo);
	boolean existsByNome(String nome);

}
