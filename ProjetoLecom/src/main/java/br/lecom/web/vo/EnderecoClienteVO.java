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
@Table(name="endereco_cliente")
@NamedQueries(value={
		
		@NamedQuery(name="queryBuscarEnderecoPorIdCliente", query="select e from EnderecoClienteVO e where e.cliente.idCliente =:idCliente"),
		@NamedQuery(name="queryBsucarEnderecoPorId", query="select e from EnderecoClienteVO e where e.idEnderecoCliente =:idEnderecoCliente")
})
public class EnderecoClienteVO extends GenericoVO {
	
	@Id
	@SequenceGenerator(name="sqEnderecoCliente", sequenceName="sq_endereco_cliente", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqEnderecoCliente")
	@Column(name="id_endereco_cliente")
	private Long idEnderecoCliente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cidade", referencedColumnName="id_cidade")
	private CidadeVO cidade;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente", referencedColumnName="id_cliente")
	private ClienteVO cliente;
	
	@Column(name="logradouro_cliente")
	private String logradouroCliente;
	
	@Column(name="bairro_cliente")
	private String bairroCliente;
	
	@Column(name="complemento_cliente")
	private String complementoCliente;
	
	@Column(name="cep_cliente")
	private String cepCliente;
	
	public EnderecoClienteVO() {


	}

	public Long getIdEnderecoCliente() {
		return idEnderecoCliente;
	}

	public void setIdEnderecoCliente(Long idEnderecoCliente) {
		this.idEnderecoCliente = idEnderecoCliente;
	}

	public CidadeVO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeVO cidade) {
		this.cidade = cidade;
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public String getLogradouroCliente() {
		return logradouroCliente;
	}

	public void setLogradouroCliente(String logradouroCliente) {
		this.logradouroCliente = logradouroCliente;
	}

	public String getBairroCliente() {
		return bairroCliente;
	}

	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}

	public String getComplementoCliente() {
		return complementoCliente;
	}

	public void setComplementoCliente(String complementoCliente) {
		this.complementoCliente = complementoCliente;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}
	
	
	

}
