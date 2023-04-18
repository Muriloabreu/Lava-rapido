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
	private List<ConsumoModel> consumos;
	
	
	public ServicoDtos(@NotNull TipoServicoModel tipoServico, @NotNull VeiculoModel veiculo, 
			@NotNull List<ConsumoModel> consumos) {
		super();
		this.tipoServico = tipoServico;
		this.veiculo = veiculo;
		
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

	
	public List<ConsumoModel> getConsumos() {
		return consumos;
	}
	
	public void setConsumos(List<ConsumoModel> consumos) {
		this.consumos = consumos;
	}
	
	
	

}
