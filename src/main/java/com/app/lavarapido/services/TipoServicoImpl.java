package com.app.lavarapido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lavarapido.models.TipoServicoModel;
import com.app.lavarapido.repositories.TipoServicoRepository;

import jakarta.transaction.Transactional;

@Service
public class TipoServicoImpl implements TipoServicoService{
	
	@Autowired
	TipoServicoRepository tipoServicoRepository;
	
	@Override
	public List<TipoServicoModel> findAll() {
		
		return tipoServicoRepository.findAll();
	}

	@Override
	public Optional<TipoServicoModel> findById(Long id) {
		
		return tipoServicoRepository.findById(id);
	}

	@Override
	@Transactional
	public TipoServicoModel save(TipoServicoModel tipoServicoModel) {
		
		return tipoServicoRepository.save(tipoServicoModel);
	}

	@Override
	@Transactional
	public void delete(TipoServicoModel tipoServicoModel) {
		tipoServicoRepository.delete(tipoServicoModel);
		
	}

	@Override
	public boolean existsByNome(String nome) {
		
		return tipoServicoRepository.existsByNome(nome);
	}

}
