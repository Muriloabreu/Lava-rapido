package com.app.lavarapido.dtos;


import java.util.List;



import com.app.lavarapido.models.ConsumoModel;
import com.app.lavarapido.models.TipoServicoModel;
import com.app.lavarapido.models.VeiculoModel;

import jakarta.validation.constraints.NotNull;

public class ServicoDtos {
	
	@NotNull
	private TipoServicoModel tipoServico;
	@NotNull
	private VeiculoModel veiculo;
	@NotNull
	private double valorTotal;
	
	private List<ConsumoModel> consumos;
	
	
	public ServicoDtos(@NotNull TipoServicoModel tipoServico, @NotNull VeiculoModel veiculo, @NotNull double valorTotal,
			@NotNull List<ConsumoModel> consumos) {
		super();
		this.tipoServico = tipoServico;
		this.veiculo = veiculo;
		this.valorTotal = valorTotal;
		this.consumos = consumos;
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

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public List<ConsumoModel> getConsumos() {
		return consumos;
	}
	
	public void setConsumos(List<ConsumoModel> consumos) {
		this.consumos = consumos;
	}
	
	
	

}
