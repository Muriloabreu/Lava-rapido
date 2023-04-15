package com.app.lavarapido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lavarapido.models.ServicoModel;
import com.app.lavarapido.repositories.ServicoRepository;

import jakarta.transaction.Transactional;

@Service
public class ServicoServiceImpl implements ServicoService{

	@Autowired
	ServicoRepository servicoRepository;
	
	@Override
	public List<ServicoModel> findAll() {
		
		return servicoRepository.findAll();
	}

	@Override
	public Optional<ServicoModel> findById(Long id) {
		
		return servicoRepository.findById(id);
	}

	@Override
	@Transactional
	public ServicoModel save(ServicoModel servico) {
		
		return servicoRepository.save(servico);
	}

	@Override
	@Transactional
	public void delete(ServicoModel servico) {
		servicoRepository.delete(servico);
		
	}

}
