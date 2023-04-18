package com.app.lavarapido.models;

import java.util.ArrayList;
import java.util.List;

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
	private double valorTotalConsumos;
	@Column(nullable = false)
	private double valorTotalServicos;
	
	
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
	public double getValorTotalConsumos() {
		
		Double somaConsumo = 0.0;
		
		for (ConsumoModel consumo : consumos) {
			
			somaConsumo += consumo.getValorTotal();
		}
		
		return somaConsumo;
	}
	public void setValorTotalConsumos(double valorTotalConsumos) {
		this.valorTotalConsumos = valorTotalConsumos;
	}
	
	public double getValorTotalServicos() {
		
		Double somaServicos = 0.0;
		
		somaServicos = tipoServico.getValor() + getValorTotalConsumos();
		
		return somaServicos;
	}
	
	public void setValorTotalServicos(double valorTotalServicos) {
		this.valorTotalServicos = valorTotalServicos;
	}
	
	
	
	
	
	
	
	
}
