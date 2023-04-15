package com.app.lavarapido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lavarapido.models.VeiculoModel;
import com.app.lavarapido.repositories.VeiculoRepository;

import jakarta.transaction.Transactional;

@Service
public class VeiculoServiceImpl implements VeiculoService{

	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Override
	public List<VeiculoModel> findAll() {
		
		return veiculoRepository.findAll();
	}

	@Override
	public Optional<VeiculoModel> findById(Long id) {
		
		return veiculoRepository.findById(id);
	}

	@Override
	@Transactional
	public VeiculoModel save(VeiculoModel veiculo) {
		
		return veiculoRepository.save(veiculo);
	}

	@Override
	@Transactional
	public void delete(VeiculoModel veiculo) {
		
		veiculoRepository.delete(veiculo);
		
	}

	@Override
	public boolean existsByPlaca(String placa) {
		
		return veiculoRepository.existsByPlaca(placa);
	}

	

}
