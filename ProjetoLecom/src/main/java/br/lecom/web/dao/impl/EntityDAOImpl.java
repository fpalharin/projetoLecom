package br.lecom.web.dao.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.UserTransaction;
import br.lecom.web.dao.service.IEntityDAO;
import br.lecom.web.vo.GenericoVO;

public abstract class EntityDAOImpl<T extends GenericoVO,ID extends Serializable> implements IEntityDAO<T, ID>{
	
public abstract EntityManager getEntityManager();
	
	public abstract UserTransaction getUserTransaction();
	
	private Class<T> classeObjeto;
	
	public EntityDAOImpl(Class<T> classeObjeto) {
		
		this.classeObjeto = classeObjeto;
		
	}
	 
	 
	@Override
	public void incluir(T objeto) throws Exception {
		
		getUserTransaction().begin();
		
			getEntityManager().persist(objeto);
		
		getUserTransaction().commit();
	}

	@Override
	public void alterar(T objeto) throws Exception {
		
		getUserTransaction().begin();
		
			getEntityManager().merge(objeto);
		
		getUserTransaction().commit();
	}

	@Override
	public void excluir(ID id) throws Exception {
		
		getUserTransaction().begin();
		
			T objetoRetorno = getEntityManager().find(classeObjeto, id);
			
			getEntityManager().remove(objetoRetorno);
		
		getUserTransaction().commit();
	}

	@Override
	public List<T> consultarTodos() throws Exception {
		
		getUserTransaction().begin();
		
			CriteriaQuery query = getEntityManager().getCriteriaBuilder().createQuery();
			
			query.select(query.from(classeObjeto));
			
			List<T> listaObjeto = getEntityManager().createQuery(query).getResultList();
		
		getUserTransaction().commit();
		
		return listaObjeto;
	}

	@Override
	public T consultarPorId(ID id) throws Exception {
		
		getUserTransaction().begin();
		
			T objetoRetorno = getEntityManager().find(classeObjeto, id);
		
		getUserTransaction().commit();
		
		return objetoRetorno;
	}
}
