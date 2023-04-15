package com.app.lavarapido.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SERVICOS")
public class ServicoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JoinColumn(name = "tipoServico_id", referencedColumnName = "id")
	private TipoServicoModel tipoServico;
	@OneToOne
	@JoinColumn(name = "veiculo_id", referencedColumnName = "id")
	private VeiculoModel veiculo;
	@OneToMany
	@JoinColumn(name = "servicos_id")
	private List<ConsumoModel> consumos = new ArrayList<>();
	@Column(nullable = false)
	private double valorTotal;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoServicoModel getTipoServico() {
		return tipoServico;
	}
	public void setTipoServico(TipoServicoModel tipoServico) {
		this.tipoServico = tipoServico;
	}
	public VeiculoModel getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(VeiculoModel veiculo) {
		this.veiculo = veiculo;
	}
	public List<ConsumoModel> getConsumos() {
		return consumos;
	}
	public void setConsumos(List<ConsumoModel> consumos) {
		this.consumos = consumos;
	}
	public double getValorTotal() {
		Double soma;
		soma = 0.0; 
		
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@Override
	public String toString() {
		return "ServicoModel [id=" + id + ", tipoServico=" + tipoServico + ", veiculo=" + veiculo + ", consumos="
				+ consumos + ", valorTotal=" + valorTotal + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(consumos, id, tipoServico, valorTotal, veiculo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicoModel other = (ServicoModel) obj;
		return Objects.equals(consumos, other.consumos) && Objects.equals(id, other.id)
				&& Objects.equals(tipoServico, other.tipoServico)
				&& Double.doubleToLongBits(valorTotal) == Double.doubleToLongBits(other.valorTotal)
				&& Objects.equals(veiculo, other.veiculo);
	}
	
	
	
	
	
	
}
