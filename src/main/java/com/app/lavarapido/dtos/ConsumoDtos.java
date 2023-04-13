package com.app.lavarapido.dtos;

import jakarta.validation.constraints.NotBlank;

public class ConsumoDtos {
	
	@NotBlank
	private String nome;
	@NotBlank
	private Long quantidade;
	@NotBlank
	private double valorTotal;
	
	public ConsumoDtos() {
		super();
	}

	public ConsumoDtos(@NotBlank String nome, @NotBlank Long quantidade, @NotBlank double valorTotal) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
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

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
