package com.app.lavarapido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lavarapido.models.ConsumoModel;
import com.app.lavarapido.repositories.ConsumoRepository;

import jakarta.transaction.Transactional;

@Service
public class ConsumoServiceImpl implements ConsumoService{
	
	@Autowired
	ConsumoRepository consumoRepository;

	@Override
	public List<ConsumoModel> findAll() {
		
		return consumoRepository.findAll();
	}

	@Override
	public Optional<ConsumoModel> findById(Long id) {
		
		return consumoRepository.findById(id);
	}

	@Override
	@Transactional
	public ConsumoModel save(ConsumoModel consumo) {
		
		return consumoRepository.save(consumo);
	}

	@Override
	@Transactional
	public void delete(ConsumoModel consumo) {
		
		consumoRepository.delete(consumo);
		
	}

	@Override
	public boolean existsByNome(String nome) {
		
		return consumoRepository.existsByNome(nome);
	}

}
