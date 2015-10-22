package br.lecom.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import br.lecom.web.dao.service.IServicoEmpresaDAO;
import br.lecom.web.vo.ClienteServicoVO;
import br.lecom.web.vo.ServicoEmpresaVO;

@RequestScoped
public class ServicoEmpresaDAOImpl extends EntityDAOImpl<ServicoEmpresaVO, Double> implements IServicoEmpresaDAO{

	@PersistenceContext(unitName="ProjetoLecom")
	private EntityManager em;
	
	@Resource
	private UserTransaction userTransaction;
	
	public ServicoEmpresaDAOImpl() {
		
		super(ServicoEmpresaVO.class);
	}

	@Override
	public EntityManager getEntityManager() {
		
		return this.em;
	}

	@Override
	public UserTransaction getUserTransaction() {
		
		return this.userTransaction;
	}
	
	@Override
	public void incluir(ServicoEmpresaVO servicoEmpresa) throws Exception {
		userTransaction.begin();
		
			em.persist(servicoEmpresa);
	
		userTransaction.commit();
	}

}
