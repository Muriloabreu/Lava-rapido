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

import com.app.lavarapido.dtos.ClienteDtos;
import com.app.lavarapido.dtos.ServicoDtos;
import com.app.lavarapido.models.ClienteModel;
import com.app.lavarapido.models.ServicoModel;
import com.app.lavarapido.services.ClienteService;
import com.app.lavarapido.services.ServicoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/lava-rapido/servicos")
public class ServicoController {
	
	
	@Autowired
	ServicoService servicoService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveServico(@RequestBody @Valid ServicoDtos servicoDtos){
		
		
		var servicoModel = new ServicoModel();
		BeanUtils.copyProperties(servicoDtos, servicoModel); /*Coverte Dtos para Model*/
		System.out.println(servicoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(servicoService.save(servicoModel));
		
	}
	
	@GetMapping
	public ResponseEntity<List<ServicoModel>>getAllServico(){
		return ResponseEntity.status(HttpStatus.OK).body(servicoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneServico(@PathVariable(value = "id") Long id) {

		Optional<ServicoModel> servicoOptional = servicoService.findById(id);

		if (!servicoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não encontrado. ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(servicoOptional.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteServico(@PathVariable(value = "id") Long id) {

		Optional<ServicoModel> servicoOptional = servicoService.findById(id);
		if (!servicoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não encontrado. ");
		}

		servicoService.delete(servicoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Serviço deletado com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateServico(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid ServicoDtos servicoDtos) {

		Optional<ServicoModel> servicoOptional = servicoService.findById(id);
		if (!servicoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serviço não encontrado. ");
		}
		
		var servicoModel = servicoOptional.get();
		servicoModel.setTipoServico(servicoDtos.getTipoServico());
		servicoModel.setVeiculo(servicoDtos.getVeiculo());
		servicoModel.setConsumos(servicoDtos.getConsumos());
		
				
		return ResponseEntity.status(HttpStatus.OK).body(servicoService.save(servicoModel));
	

	}

}
