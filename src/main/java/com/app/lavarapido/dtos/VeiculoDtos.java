package com.app.lavarapido.dtos;

import java.time.LocalDateTime;
import com.app.lavarapido.models.ClienteModel;
import jakarta.validation.constraints.NotBlank;

public class VeiculoDtos {
	
	@NotBlank
	private String placa;
	@NotBlank
	private String fabricante;
	@NotBlank
	private String modelo;
	@NotBlank
	private String cor;
	@NotBlank
	private LocalDateTime registrationDate;
	@NotBlank
	private ClienteModel cliente;
	
	public VeiculoDtos() {
		super();
	}

	public VeiculoDtos(@NotBlank String placa, @NotBlank String fabricante, @NotBlank String modelo,
			@NotBlank String cor, @NotBlank LocalDateTime registrationDate, @NotBlank ClienteModel cliente) {
		super();
		this.placa = placa;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.cor = cor;
		this.registrationDate = registrationDate;
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

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	
	
	
	

}
