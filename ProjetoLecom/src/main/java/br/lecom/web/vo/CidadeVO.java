package br.lecom.web.vo;

import javax.persistence.Cacheable;
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
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
@NamedQueries(value={
		
		@NamedQuery(name="buscarCidadePorEstado",query="select c from CidadeVO c where c.estado.idEstado = :idEstado",
				hints={@QueryHint(name="org.hibernate.cacheable", value="true")})
})
@Cacheable(true)
public class CidadeVO extends GenericoVO{
	
	@Id
	@SequenceGenerator(name="sqCidade", sequenceName="sq_cidade", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqCidade")
	@Column(name="id_cidade")
	private Double idCidade;
	
	@Column(name="nome_cidade")
	private String nomeCidade;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_estado", referencedColumnName="id_estado")
	private EstadoVO estado;
	
	public CidadeVO(){
		
	}

	public Double getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Double idCidade) {
		this.idCidade = idCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public EstadoVO getEstado() {
		return estado;
	}

	public void setEstado(EstadoVO estado) {
		this.estado = estado;
	}
	
	
}
