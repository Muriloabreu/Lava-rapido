package com.app.lavarapido.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lavarapido.models.ClienteModel;
import com.app.lavarapido.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public List<ClienteModel> findAll() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Optional<ClienteModel> findById(Long id) {
		
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public ClienteModel save(ClienteModel cliente) {
		
		return clienteRepository.save(cliente);
	}

	@Override
	public void delete(ClienteModel cliente) {
		
		clienteRepository.delete(cliente);
		
	}

	@Override
	public boolean existsByCpf(String cpf) {
		
		return clienteRepository.existsByCpf(cpf);
	}

}
