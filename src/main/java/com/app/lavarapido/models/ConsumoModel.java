package com.app.lavarapido.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONSUMOS")
public class ConsumoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, length = 100)
	private Long quantidade;
	@Column(nullable = false)
	private double valorUnidade;
	@Column(nullable = false)
	private double valorTotal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		
		Double valorTot = 0.0;
		
		valorTot = getQuantidade() * getValorUnidade();
		
		
		return valorTot;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public double getValorUnidade() {
		return valorUnidade;
	}
	
	public void setValorUnidade(double valorUnidade) {
		this.valorUnidade = valorUnidade;
	}
	
	@Override
	public String toString() {
		return "ConsumoModel [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", valorUnidade="
				+ valorUnidade + ", valorTotal=" + valorTotal + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, quantidade, valorTotal, valorUnidade);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsumoModel other = (ConsumoModel) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(quantidade, other.quantidade)
				&& Double.doubleToLongBits(valorTotal) == Double.doubleToLongBits(other.valorTotal)
				&& Double.doubleToLongBits(valorUnidade) == Double.doubleToLongBits(other.valorUnidade);
	}
	
	
	
	
	
	

}
