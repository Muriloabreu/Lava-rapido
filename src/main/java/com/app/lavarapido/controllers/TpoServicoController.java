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

import com.app.lavarapido.dtos.TipoServicoDtos;
import com.app.lavarapido.models.TipoServicoModel;
import com.app.lavarapido.services.TipoServicoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/lava-rapido/tiposervicos")
public class TpoServicoController {
	
	
	@Autowired
	TipoServicoService tipoServicoService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveTipoServico(@RequestBody @Valid TipoServicoDtos tipoServicoDtos){
		
		if (tipoServicoService.existsByNome(tipoServicoDtos.getNome())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Tipo de Serviço já cadastrado!"); /* Check se livro já está cadastrada */
		}
		
		TipoServicoModel tipoServicoModel = new TipoServicoModel();
		BeanUtils.copyProperties(tipoServicoDtos, tipoServicoModel); /*Coverte Dtos para Model*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoServicoService.save(tipoServicoModel));
	}
	
	@GetMapping
	public ResponseEntity<List<TipoServicoModel>>getAllTipoServico(){
		
		return ResponseEntity.status(HttpStatus.OK).body(tipoServicoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneTipoServico(@PathVariable(value = "id") Long id) {

		Optional<TipoServicoModel> tipoServicoOptional = tipoServicoService.findById(id);

		if (!tipoServicoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Serviço não encontrado. ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(tipoServicoOptional.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTipoServico(@PathVariable(value = "id") Long id) {

		Optional<TipoServicoModel> tipoServicoOptional = tipoServicoService.findById(id);

		if (!tipoServicoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Serviço não encontrado. ");
		}

		tipoServicoService.delete(tipoServicoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Tipo de Serviço deletado com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTipoServico(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid TipoServicoDtos tipoServicoDtos) {

		Optional<TipoServicoModel> tipoServicoOptional = tipoServicoService.findById(id);
		if (!tipoServicoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Serviço não encontrado. ");
		}
		
		var tipoServicoModel = tipoServicoOptional.get();
		tipoServicoModel.setNome(tipoServicoDtos.getNome());
		tipoServicoModel.setValor(tipoServicoDtos.getValor());
		
		
				
		return ResponseEntity.status(HttpStatus.OK).body(tipoServicoService.save(tipoServicoModel));
	

	}

}
