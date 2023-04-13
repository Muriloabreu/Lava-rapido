package com.app.lavarapido.services;

import java.util.List;
import java.util.Optional;


import com.app.lavarapido.models.TipoServicoModel;

public interface TipoServicoService {
	
	List<TipoServicoModel> findAll();
	Optional<TipoServicoModel> findById(Long id);
	TipoServicoModel save(TipoServicoModel cliente);
	void delete(TipoServicoModel livro);
	boolean existsByNome(String nome);

}
