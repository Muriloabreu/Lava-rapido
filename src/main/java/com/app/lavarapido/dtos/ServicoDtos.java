package com.app.lavarapido.dtos;


import com.app.lavarapido.models.TipoServicoModel;
import com.app.lavarapido.models.VeiculoModel;


import jakarta.validation.constraints.NotBlank;

public class ServicoDtos {
	
	@NotBlank
	private TipoServicoModel tipoServico;
	@NotBlank
	private VeiculoModel veiculo;
	@NotBlank
	private double valorTotal;
	
	public ServicoDtos() {
		super();
	}

	public ServicoDtos(@NotBlank TipoServicoModel tipoServico, @NotBlank VeiculoModel veiculo,
			@NotBlank double valorTotal) {
		super();
		this.tipoServico = tipoServico;
		this.veiculo = veiculo;
		this.valorTotal = valorTotal;
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
	
	
	

}
