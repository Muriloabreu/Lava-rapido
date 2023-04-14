package com.app.lavarapido.services;

import java.util.List;
import java.util.Optional;


import com.app.lavarapido.models.ServicoModel;

public interface ServicoService {
	
	List<ServicoModel> getAllServico();
	Optional<ServicoModel> findById(Long id);
	ServicoModel save(ServicoModel servico);
	void delete(ServicoModel servico);

}
