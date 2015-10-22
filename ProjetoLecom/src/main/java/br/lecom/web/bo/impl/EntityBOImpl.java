package br.lecom.web.bo.impl;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.lecom.web.bo.service.IEntityBO;
import br.lecom.web.vo.GenericoVO;
import br.lecom.web.dao.service.IEntityDAO;

public abstract class EntityBOImpl<T extends GenericoVO, ID extends Serializable> implements IEntityBO<T, ID>{
	
	public abstract IEntityDAO getEntityDao();
	
	public abstract Logger getLogger();
	
	@Override
	public boolean incluir(T objeto) {
		try {
			
			getEntityDao().incluir(objeto);
			
		}catch(Exception e){
			getLogger().log(Level.SEVERE, e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean alterar(T objeto) {
		try {
			
			getEntityDao().alterar(objeto);
			
		}catch(Exception e){
			getLogger().log(Level.SEVERE, e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean excluir(ID id) {
		try {
			
			getEntityDao().excluir(id);
			
		}catch(Exception e){
			getLogger().log(Level.SEVERE, e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public List<T> consultarTodos() {
		List<T> listaObjetos = null;
		try {
			
			listaObjetos = getEntityDao().consultarTodos();
			
		}catch(Exception e){
			getLogger().log(Level.SEVERE, e.getMessage());
			listaObjetos = null;
		}
		
		return listaObjetos;
	}

	@Override
	public T consultarPorId(ID id) {
		
		T objeto = null;
		
		try {
			
			objeto = (T) getEntityDao().consultarPorId(id);
			
		}catch(Exception e){
			getLogger().log(Level.SEVERE, e.getMessage());
			objeto = null;
		}
		return objeto;
	}


}
