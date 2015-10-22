package br.lecom.web.dao.service;

import java.util.List;

import br.lecom.web.vo.CidadeVO;

public interface ICidadeDAO extends IEntityDAO<CidadeVO, Double>{
	
	List<CidadeVO> consultarCidadePorEstado(Double idEstado) throws Exception;
}
