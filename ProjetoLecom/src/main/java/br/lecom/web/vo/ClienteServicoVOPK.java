package br.lecom.web.vo;

import java.io.Serializable;


public class ClienteServicoVOPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double cliente;
	
	private Double servico;
	
	@Override
	public boolean equals(Object objeto) {
		if(objeto == null || !(objeto instanceof ClienteServicoVOPK)){
			
			return false;
		}
		
		ClienteServicoVOPK pk = (ClienteServicoVOPK) objeto;
		
		return this.cliente.equals(pk.cliente) && this.servico.equals(pk.servico);
	}
	
	@Override
	public int hashCode() {
		
		return cliente.hashCode() + servico.hashCode();
	}

	public Double getCliente() {
		return cliente;
	}

	public void setCliente(Double cliente) {
		this.cliente = cliente;
	}

	public Double getServico() {
		return servico;
	}

	public void setServico(Double servico) {
		this.servico = servico;
	}

}
