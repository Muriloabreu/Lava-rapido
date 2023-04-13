package com.app.lavarapido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lavarapido.models.VeiculoModel;

import jakarta.transaction.Transactional;

@Service
public class VeiculoServiceImpl implements VeiculoService{

	@Autowired
	VeiculoService veiculoService;
	
	@Override
	public List<VeiculoModel> findAll() {
		
		return veiculoService.findAll();
	}

	@Override
	public Optional<VeiculoModel> findById(Long id) {
		
		return veiculoService.findById(id);
	}

	@Override
	@Transactional
	public VeiculoModel save(VeiculoModel veiculo) {
		
		return veiculoService.save(veiculo);
	}

	@Override
	public void delete(VeiculoModel veiculo) {
		
		veiculoService.delete(veiculo);
		
	}

	@Override
	public boolean existsByPlaca(String placa) {
		
		return veiculoService.existsByPlaca(placa);
	}

}
