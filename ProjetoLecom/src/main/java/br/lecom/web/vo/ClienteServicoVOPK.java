package br.lecom.web.vo;

import java.io.Serializable;


public class ClienteServicoVOPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long cliente;
	
	private Long servico;
	
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

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Long getServico() {
		return servico;
	}

	public void setServico(Long servico) {
		this.servico = servico;
	}

}
