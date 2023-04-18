package com.app.lavarapido.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ConsumoDtos {
	
	@NotBlank
	private String nome;
	@NotNull
	private Long quantidade;
	@NotNull
	private double valorUnidade;
	@NotNull
	private double valorTotal;
	
	public ConsumoDtos() {
		super();
	}

	public ConsumoDtos(@NotBlank String nome, @NotNull Long quantidade, @NotNull double valorUnidade ,@NotNull double valorTotal) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorUnidade = valorUnidade;
		this.valorTotal = valorTotal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getValorUnidade() {
		return valorUnidade;
	}
	
	public void setValorUnidade(double valorUnidade) {
		this.valorUnidade = valorUnidade;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
