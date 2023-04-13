package com.app.lavarapido.controllers;

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

import com.app.lavarapido.dtos.ConsumoDtos;
import com.app.lavarapido.models.ConsumoModel;
import com.app.lavarapido.services.ConsumoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/lava-rapido/consumos")
public class ConsumoController {
	
	@Autowired
	ConsumoService consumoService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveConsumo(@RequestBody @Valid ConsumoDtos consumoDtos){
		
		if (consumoService.existsByNome(consumoDtos.getNome())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Consumo já cadastrado!"); /* Check se livro já está cadastrada */
		}
		
		ConsumoModel consumoModel = new ConsumoModel();
		BeanUtils.copyProperties(consumoDtos, consumoModel); /*Coverte Dtos para Model*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(consumoService.save(consumoModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ConsumoModel>>getAllConsumos(){
		return ResponseEntity.status(HttpStatus.OK).body(consumoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneConsumo(@PathVariable(value = "id") Long id) {

		Optional<ConsumoModel> consumoOptional = consumoService.findById(id);
		if (!consumoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consumo não encontrado. ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(consumoOptional.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteConsumo(@PathVariable(value = "id") Long id) {

		Optional<ConsumoModel> consumoOptional = consumoService.findById(id);
		if (!consumoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consumo não encontrado. ");
		}

		consumoService.delete(consumoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Consumo deletado com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateConsumo(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid ConsumoDtos consumoDtos) {

		Optional<ConsumoModel> consumoOptional = consumoService.findById(id);
		if (!consumoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consumo não encontrado. ");
		}
		
		var consumoModel = consumoOptional.get();
		consumoModel.setNome(consumoDtos.getNome());
		consumoModel.setQuantidade(consumoDtos.getQuantidade());
		consumoModel.setValorTotal(consumoDtos.getValorTotal());
		
				
		return ResponseEntity.status(HttpStatus.OK).body(consumoService.save(consumoModel));
	

	}

}
