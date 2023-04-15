package com.app.lavarapido.dtos;


import com.app.lavarapido.models.ClienteModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VeiculoDtos {
	
	@NotBlank
	@Size(max =7)
	private String placa;
	@NotBlank
	private String fabricante;
	@NotBlank
	private String modelo;
	@NotBlank
	private String cor;
	@NotNull
	private ClienteModel cliente;
	
	public VeiculoDtos() {
		super();
	}

	

	public VeiculoDtos(@NotBlank String placa, @NotBlank String fabricante, @NotBlank String modelo,
			@NotBlank String cor, @NotNull ClienteModel cliente) {
		super();
		this.placa = placa;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.cor = cor;
		this.cliente = cliente;
	}



	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}


	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	
	
	
	

}
