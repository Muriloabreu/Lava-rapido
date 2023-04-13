package com.app.lavarapido.models;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_VEICULOS")
public class VeiculoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true, length = 7)
	private String placaCarro;
	@Column(nullable = false, length = 70)
	private String fabricante;
	@Column(nullable = false, length = 70)
	private String modelo;
	@Column(nullable = false, length = 70)
	private String cor;
	@Column(nullable = false)
	private LocalDateTime registrationDate;
	@OneToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private ClienteModel cliente;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlacaCarro() {
		return placaCarro;
	}
	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
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
	
	@Override
	public String toString() {
		return "VeiculoModel [id=" + id + ", placaCarro=" + placaCarro + ", fabricante=" + fabricante + ", modelo="
				+ modelo + ", cor=" + cor + ", registrationDate=" + registrationDate + ", cliente=" + cliente + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cliente, cor, fabricante, id, modelo, placaCarro, registrationDate);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeiculoModel other = (VeiculoModel) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(cor, other.cor)
				&& Objects.equals(fabricante, other.fabricante) && Objects.equals(id, other.id)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(placaCarro, other.placaCarro)
				&& Objects.equals(registrationDate, other.registrationDate);
	}
	
	
	
	

}
