package br.lecom.web.bo.service;

import java.io.Serializable;
import java.util.List;

import br.lecom.web.vo.GenericoVO;

public interface IEntityBO<T extends GenericoVO, ID extends Serializable> {
	
	boolean incluir(T objeto);
	boolean alterar(T objeto);
	boolean excluir(ID id);
	List<T> consultarTodos();
	T consultarPorId(ID id);
}
