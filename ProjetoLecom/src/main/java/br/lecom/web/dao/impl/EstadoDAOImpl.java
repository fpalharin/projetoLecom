package br.lecom.web.dao.impl;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import br.lecom.web.dao.service.IEstadoDAO;
import br.lecom.web.vo.EstadoVO;

@RequestScoped
public class EstadoDAOImpl extends EntityDAOImpl<EstadoVO, Long> implements IEstadoDAO{
	
	@PersistenceContext(unitName="ProjetoLecom")
	private EntityManager em;
	
	@Resource
	private UserTransaction userTransaction;
	
	public EstadoDAOImpl() {
		
		super(EstadoVO.class);
	}
	
	@Override
	public EntityManager getEntityManager() {
		
		return this.em;
	}

	@Override
	public UserTransaction getUserTransaction() {

		return this.userTransaction;
	}

}
