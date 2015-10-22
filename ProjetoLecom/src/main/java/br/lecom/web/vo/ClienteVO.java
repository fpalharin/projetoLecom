package br.lecom.web.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="cliente")
@NamedQueries(value={
		
		@NamedQuery(name="queryBuscarClientePorNome", query="select c from ClienteVO c where lower(c.nomeCliente) like :nomeCliente"),
		@NamedQuery(name="queryBuscarClientePorCpf", query="select c from ClienteVO c where trim(c.cpfCliente)=:cpfCliente"),
		@NamedQuery(name="queryBuscarTodosClientes", query="select c from ClienteVO c"),
		
})
public class ClienteVO extends GenericoVO{
	
	@Id
	@SequenceGenerator(name="sqCliente", sequenceName="sq_cliente", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqCliente")
	@Column(name="id_cliente")
	private Double idCliente;
	
	
	@Column(name="nome_cliente")
	private String nomeCliente;
	
	@Column(name="rg_cliente")
	private String rgCliente;
	
	@Column(name="email_cliente")
	private String emailCliente;
	
	@Column(name="cpf_cliente")
	private String cpfCliente;
	
	@Column(name="cod_cliente")
	private Long codCliente;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<EnderecoClienteVO> listaEnderecos;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<TelefoneClienteVO> listaTelefones;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})
	private List<ClienteServicoVO> listaClienteServicos;
	
	@Transient
	private List<ServicoEmpresaVO> listaServicos;
	
	@Transient
	private List<EnderecoClienteVO> listaEnderecoAuxInc;
	
	@Transient
	private List<EnderecoClienteVO> listaEnderecoAuxExc;
	
	@Transient
	private List<TelefoneClienteVO> listaTelefoneAuxInc;
	
	@Transient
	private List<TelefoneClienteVO> listaTelefoneAuxExc;
	
	public ClienteVO(){
		
	}

	public Double getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Double idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getRgCliente() {
		return rgCliente;
	}

	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}
	
	public String getEmailCliente(){
		return emailCliente;
	}
	
	public void setEmailCliente(String emailCliente){
		this.emailCliente = emailCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Long getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Long codCliente) {
		this.codCliente = codCliente;
	}

	public List<EnderecoClienteVO> getListaEnderecos() {
		return listaEnderecos;
	}

	public void setListaEnderecos(List<EnderecoClienteVO> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}

	public List<TelefoneClienteVO> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<TelefoneClienteVO> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	public List<ClienteServicoVO> getListaClienteServicos() {
		return listaClienteServicos;
	}

	public void setListaClienteServicos(List<ClienteServicoVO> listaClienteServicos) {
		this.listaClienteServicos = listaClienteServicos;
	}

	public List<ServicoEmpresaVO> getListaServicos() {
		return listaServicos;
	}

	public void setListaServicos(List<ServicoEmpresaVO> listaServicos) {
		this.listaServicos = listaServicos;
	}

	public List<EnderecoClienteVO> getListaEnderecoAuxInc() {
		return listaEnderecoAuxInc;
	}

	public void setListaEnderecoAuxInc(List<EnderecoClienteVO> listaEnderecoAuxInc) {
		this.listaEnderecoAuxInc = listaEnderecoAuxInc;
	}

	public List<EnderecoClienteVO> getListaEnderecoAuxExc() {
		return listaEnderecoAuxExc;
	}

	public void setListaEnderecoAuxExc(List<EnderecoClienteVO> listaEnderecoAuxExc) {
		this.listaEnderecoAuxExc = listaEnderecoAuxExc;
	}

	public List<TelefoneClienteVO> getListaTelefoneAuxInc() {
		return listaTelefoneAuxInc;
	}

	public void setListaTelefoneAuxInc(List<TelefoneClienteVO> listaTelefoneAuxInc) {
		this.listaTelefoneAuxInc = listaTelefoneAuxInc;
	}

	public List<TelefoneClienteVO> getListaTelefoneAuxExc() {
		return listaTelefoneAuxExc;
	}

	public void setListaTelefoneAuxExc(List<TelefoneClienteVO> listaTelefoneAuxExc) {
		this.listaTelefoneAuxExc = listaTelefoneAuxExc;
	}

}
