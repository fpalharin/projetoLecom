package br.lecom.web.dao.service;

import java.util.List;

import br.lecom.web.vo.CidadeVO;

public interface ICidadeDAO extends IEntityDAO<CidadeVO, Long>{
	
	List<CidadeVO> consultarCidadePorEstado(Long idEstado) throws Exception;
}
