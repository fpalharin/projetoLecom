package br.lecom.web.dao.service;

import java.util.List;

import br.lecom.web.vo.ClienteServicoVO;
import br.lecom.web.vo.ClienteVO;
import br.lecom.web.vo.EnderecoClienteVO;
import br.lecom.web.vo.TelefoneClienteVO;


public interface IClienteDAO extends IEntityDAO<ClienteVO, Double>{
	
	List<ClienteVO> consultarClientePorNome(String nomeCliente)throws Exception;
	ClienteVO consultarClientePorCpf(String cpfCliente) throws Exception;
	ClienteVO detalharCliente(Double idCliente) throws Exception;
	
	boolean alterarEnderecoCliente(EnderecoClienteVO endereco) throws Exception;
	boolean alterarTelefoneCliente(TelefoneClienteVO telefone) throws Exception;
	
	List<EnderecoClienteVO> consultarEnderecoClientePorIdCliente(Double idCliente) throws Exception;
	List<TelefoneClienteVO> consultarTelefoneClientePorIdCliente(Double idCliente) throws Exception;
	List<ClienteServicoVO> consultarServicosPorCliente(Double idCliente) throws Exception;
	
	TelefoneClienteVO consultarTelefoneClientePorId(Double idTelefone) throws Exception;
	EnderecoClienteVO consultarEnderecoClientePorId(Double idEndereco) throws Exception;
	
	boolean excluirCliente(ClienteVO cliente) throws Exception;
	boolean excluirEnderecoCliente(EnderecoClienteVO endereco) throws Exception;
	boolean excluirTelefoneCliente(TelefoneClienteVO telefone) throws Exception;

}
