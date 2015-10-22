package br.lecom.web.dao.service;

import java.io.Serializable;
import java.util.List;

import br.lecom.web.vo.GenericoVO;

public interface IEntityDAO<T extends GenericoVO,ID extends Serializable> {
	
	void incluir(T objeto) throws Exception;
	void alterar(T objeto) throws Exception;
	void excluir(ID id) throws Exception;
	List<T> consultarTodos() throws Exception;
	T consultarPorId(ID id) throws Exception;

}
