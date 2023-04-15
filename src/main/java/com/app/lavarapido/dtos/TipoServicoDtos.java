package com.app.lavarapido.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TipoServicoDtos {
	
	@NotBlank
	private String nome;
	@NotNull
	private double valor;
	
	
	public TipoServicoDtos() {
		super();
	}
	
	
	public TipoServicoDtos(@NotBlank String nome, @NotNull double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	

}
