package br.lecom.web.dao.impl;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import br.lecom.web.dao.service.ICidadeDAO;
import br.lecom.web.vo.CidadeVO;
import br.lecom.web.anotacoes.ConnectionQualifier;
import br.lecom.web.enumeradores.TipoConexao;

@RequestScoped
public class CidadeDAOImpl extends EntityDAOImpl<CidadeVO, Long> implements ICidadeDAO{



	public CidadeDAOImpl() {
		
		super(CidadeVO.class);
		
	}

	@PersistenceContext(unitName="ProjetoLecom")
	private EntityManager em;
	
	@Resource
	private UserTransaction userTransaction;

	@Inject
	@ConnectionQualifier(tipoConexao = TipoConexao.ORACLE)
	private Connection conexao;
	
	
	@Override
	public EntityManager getEntityManager() {
		
		return this.em;
	}

	@Override
	public UserTransaction getUserTransaction() {
		
		return this.userTransaction;
	}


	@Override
	public List<CidadeVO> consultarCidadePorEstado(Long idEstado) throws Exception{
		
		List<CidadeVO> listaCidades = null;
		
		try{
			userTransaction.begin();
				
				Query query = em.createNamedQuery("buscarCidadePorEstado");
				query.setParameter("idEstado", idEstado);
				
				
				listaCidades = query.getResultList();
			
			userTransaction.commit();
			
		}
		catch(NoResultException e){
			
			listaCidades = null;
		}
		
		return listaCidades;
	}
	

}
