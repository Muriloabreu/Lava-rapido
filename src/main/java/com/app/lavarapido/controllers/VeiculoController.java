package com.app.lavarapido.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.lavarapido.dtos.VeiculoDtos;
import com.app.lavarapido.models.VeiculoModel;
import com.app.lavarapido.services.VeiculoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/lava-rapido/veiculos")
public class VeiculoController {
	
	@Autowired
	VeiculoService veiculoService;
	
	@PostMapping
	public ResponseEntity<Object> saveVeiculo(@RequestBody @Valid VeiculoDtos veiculoDtos){
		
		if (veiculoService.existsByPlaca(veiculoDtos.getPlaca())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Veículo já cadastrado!"); /* Check se veiculo já está cadastrada */
		}
		
		VeiculoModel veiculoModel = new VeiculoModel();
		BeanUtils.copyProperties(veiculoDtos, veiculoModel); /*Coverte Dtos para Model*/
		veiculoModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC"))); /* è um set de Data */
		return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.save(veiculoModel));
	}
	
	@GetMapping
	public ResponseEntity<List<VeiculoModel>>getAllVeiculos(){
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneVeiculo(@PathVariable(value = "id") Long id) {

		Optional<VeiculoModel> veiculoOptional = veiculoService.findById(id);
		if (!veiculoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado. ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(veiculoOptional.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteVeiculo(@PathVariable(value = "id") Long id) {

		Optional<VeiculoModel> veiculoOptional = veiculoService.findById(id);
		if (!veiculoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado. ");
		}

		veiculoService.delete(veiculoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Veículo deletado com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateVeiculo(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid VeiculoDtos veiculoDtos) {

		Optional<VeiculoModel> veiculoOptional = veiculoService.findById(id);
		if (!veiculoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não encontrado. ");
		}
		
		
		var veiculoModel = veiculoOptional.get();
		veiculoModel.setPlaca(veiculoDtos.getPlaca());
		veiculoModel.setFabricante(veiculoDtos.getFabricante());
		veiculoModel.setModelo(veiculoDtos.getModelo());
		veiculoModel.setCor(veiculoDtos.getCor());
		veiculoModel.setRegistrationDate(veiculoModel.getRegistrationDate());
		veiculoModel.setCliente(veiculoDtos.getCliente());		
				
		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.save(veiculoModel));
	

	}
	

}
