package br.lecom.web.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="telefone_cliente")
@NamedQueries(value={
		
		@NamedQuery(name="queryBuscarTelefonePorIdCliente", query="select t from TelefoneClienteVO t where t.cliente.idCliente =:idCliente"),
		@NamedQuery(name="queryBsucarTelefonePorId", query="select t from TelefoneClienteVO t where t.idTelefoneCliente =:idTelefoneCliente")
})
public class TelefoneClienteVO extends GenericoVO{

	@Id
	@SequenceGenerator(name="sqTelefoneCliente", sequenceName="sq_telefone_cliente", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqTelefoneCliente")
	@Column(name="id_telefone_cliente")
	private Double idTelefoneCliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente", referencedColumnName="id_cliente")
	private ClienteVO cliente;
	
	@Column(name="telefone_cliente")
	private String telefoneCliente;
	
	@Column(name="ddd_cliente")
	private String dddCliente;
	
	@Column(name="tipo_telefone")
	private String tipoTelefone;
	
	public TelefoneClienteVO() {
	
	
	}
	
	
	

	public Double getIdTelefoneCliente() {
		return idTelefoneCliente;
	}

	public void setIdTelefoneCliente(Double idTelefoneCliente) {
		this.idTelefoneCliente = idTelefoneCliente;
	}


	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}


	public String getDddCliente() {
		return dddCliente;
	}

	public void setDddCliente(String dddCliente) {
		this.dddCliente = dddCliente;
	}


	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	
}
