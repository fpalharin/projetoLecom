package br.lecom.web.vo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@IdClass(ClienteServicoVOPK.class)
@Table(name="cliente_servico")
@NamedQueries(value={
		
		@NamedQuery(name="queryBuscarServicoPorCliente", query="select cs from ClienteServicoVO cs where cs.cliente.idCliente =:idCliente")
})
public class ClienteServicoVO extends GenericoVO{
	
	@Id
	@JoinColumn(name="id_cliente",referencedColumnName="id_cliente")
	@ManyToOne(fetch=FetchType.EAGER)
	private ClienteVO cliente;
	
	@Id
	@JoinColumn(name="id_servico_empresa",referencedColumnName="id_servico_empresa")
	@ManyToOne(fetch=FetchType.EAGER)
	private ServicoEmpresaVO servico;
	
	@Column(name="data_inicio")
	private Date dataInicio;
	
	@Column(name="data_fim")
	private Date dataFim;
	
	public ClienteServicoVO() {

	}

	
	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public ServicoEmpresaVO getServico() {
		return servico;
	}

	public void setServico(ServicoEmpresaVO servico) {
		this.servico = servico;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	
	

}
