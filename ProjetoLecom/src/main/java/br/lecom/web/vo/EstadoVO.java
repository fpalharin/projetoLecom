package br.lecom.web.vo;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="estado")
@Cacheable(true)
public class EstadoVO extends GenericoVO{
	
	@Id
	@SequenceGenerator(name="sqEstado", sequenceName="sq_estado", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqEstado")
	@Column(name="id_estado")
	private Long idEstado;
	
	@Column(name="nome_estado")
	private String nomeEstado;
	
	@Column(name="sigla_estado")
	private String siglaEstado;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="estado")
	private List<CidadeVO> listaCidades;
	
	
	public EstadoVO() {
	
	
	}


	public Long getIdEstado() {
		return idEstado;
	}


	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}


	public String getNomeEstado() {
		return nomeEstado;
	}


	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}


	public String getSiglaEstado() {
		return siglaEstado;
	}


	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}


	public List<CidadeVO> getListaCidades() {
		return listaCidades;
	}


	public void setListaCidades(List<CidadeVO> listaCidades) {
		this.listaCidades = listaCidades;
	}
	
	
}
