package br.lecom.web.vo;

import java.util.List;

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
@Table(name="servico_empresa")
public class ServicoEmpresaVO extends GenericoVO{
	

	@Id
	@SequenceGenerator(name="sqServicoEmpresa", sequenceName="sq_servico_empresa", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqServicoEmpresa")
	@Column(name="id_servico_empresa")
	private Double idServicoEmpresa;
	
	@Column(name="nome_servico")
	private String nomeServico;
	
	@Column(name="cod_servico")
	private Long codServico;
	
	@Column(name="descricao_servico")
	private String descricaoServico;
	
	@OneToMany(mappedBy="servico",fetch=FetchType.LAZY)
	private List<ClienteServicoVO> listaClienteServicos;
	
	@Transient
	private List<ClienteVO> listaClientes;
	
	public ServicoEmpresaVO() {
		
		
	}

	public Double getIdServicoEmpresa() {
		return idServicoEmpresa;
	}

	public void setIdServicoEmpresa(Double idServicoEmpresa) {
		this.idServicoEmpresa = idServicoEmpresa;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public Long getCodServico() {
		return codServico;
	}

	public void setCodServico(Long codServico) {
		this.codServico = codServico;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public List<ClienteServicoVO> getListaClienteServicos() {
		return listaClienteServicos;
	}

	public void setListaClienteServicos(List<ClienteServicoVO> listaClienteServicos) {
		this.listaClienteServicos = listaClienteServicos;
	}

	public List<ClienteVO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<ClienteVO> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
	
}
