package br.lecom.web.dao.service;

import java.util.List;

import br.lecom.web.vo.ClienteServicoVO;
import br.lecom.web.vo.ClienteVO;
import br.lecom.web.vo.EnderecoClienteVO;
import br.lecom.web.vo.TelefoneClienteVO;


public interface IClienteDAO extends IEntityDAO<ClienteVO, Long>{
	
	List<ClienteVO> consultarClientePorNome(String nomeCliente)throws Exception;
	ClienteVO consultarClientePorCpf(String cpfCliente) throws Exception;
	ClienteVO detalharCliente(Long idCliente) throws Exception;
	
	boolean alterarEnderecoCliente(EnderecoClienteVO endereco) throws Exception;
	boolean alterarTelefoneCliente(TelefoneClienteVO telefone) throws Exception;
	
	List<EnderecoClienteVO> consultarEnderecoClientePorIdCliente(Long idCliente) throws Exception;
	List<TelefoneClienteVO> consultarTelefoneClientePorIdCliente(Long idCliente) throws Exception;
	List<ClienteServicoVO> consultarServicosPorCliente(Long idCliente) throws Exception;
	
	TelefoneClienteVO consultarTelefoneClientePorId(Long idTelefone) throws Exception;
	EnderecoClienteVO consultarEnderecoClientePorId(Long idEndereco) throws Exception;
	
	boolean excluirCliente(ClienteVO cliente) throws Exception;
	boolean excluirEnderecoCliente(EnderecoClienteVO endereco) throws Exception;
	boolean excluirTelefoneCliente(TelefoneClienteVO telefone) throws Exception;

}
