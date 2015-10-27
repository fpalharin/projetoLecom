package br.lecom.web.bo.impl;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import br.lecom.web.dao.service.IClienteDAO;
import br.lecom.web.dao.service.IEntityDAO;
import br.lecom.web.util.UtilFuncoes;
import br.lecom.web.vo.CidadeVO;
import br.lecom.web.vo.ClienteVO;
import br.lecom.web.vo.EnderecoClienteVO;
import br.lecom.web.vo.EstadoVO;
import br.lecom.web.vo.TelefoneClienteVO;
import br.lecom.web.dao.service.ICidadeDAO;
import br.lecom.web.dao.service.IEstadoDAO;



public class ClienteBO extends EntityBOImpl<ClienteVO, Long> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IClienteDAO dao;
	
	@Inject
	private Logger log;
	
	@Inject
	private IEstadoDAO estado;
	
	@Inject
	private ICidadeDAO cidade;
	

	@Override
	public IEntityDAO getEntityDao() {
		
		return this.dao;
	}

	@Override
	public Logger getLogger() {
		
		return this.log;
	}
	
	public List<ClienteVO> consultarClientePorNome(String nomeCliente){
		
		List<ClienteVO> listaClientes = null;
		
		try {
			
			listaClientes = dao.consultarClientePorNome(nomeCliente);
			
		} catch (Exception e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
			listaClientes = null;
		}
		
		return listaClientes;
	}
	
	public ClienteVO consultarClientePorCpf(String cpfCliente){
		
		ClienteVO cliente = null;
		
		try {
			
			cliente = dao.consultarClientePorCpf(cpfCliente);
			
		} catch (Exception e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
			cliente = null;
			
		}
		
		
		return cliente;
	}
	
	public ClienteVO detalharCliente(Long idCliente){
		
		ClienteVO cliente = null;
		
		try {
			
			cliente = dao.detalharCliente(idCliente);
			
		} catch (Exception e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
			cliente = null;
		}
		
		
		return cliente;
	}
	
	@Override
	public boolean alterar(ClienteVO cliente) {
		
		try {
			
			dao.alterar(cliente);
		
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			return false;
		}
		
		return true;
	}
	
	public boolean alterarEnderecoCliente(EnderecoClienteVO endereco){
		
		try {
			
			dao.alterarEnderecoCliente(endereco);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			return false;
		}
		
		return true;
	}
	
	public boolean alterarTelefoneCliente(TelefoneClienteVO telefone){
		
		try {
			
			dao.alterarTelefoneCliente(telefone);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			return false;
		}
		
		return true;
	}
	
	public List<EnderecoClienteVO> consultarEnderecoClientePorIdCliente(Long idCliente){
		
		List<EnderecoClienteVO> listaEnderecos = null;
		
		try {
			
			listaEnderecos = dao.consultarEnderecoClientePorIdCliente(idCliente);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			listaEnderecos = null;
		}
		
		return listaEnderecos;
	}
	
	public List<TelefoneClienteVO> consultarTelefoneClientePorIdCliente(Long idCliente){
		
		List<TelefoneClienteVO> listaTelefones = null;
		
		try {
			
			listaTelefones = dao.consultarTelefoneClientePorIdCliente(idCliente);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			listaTelefones = null;
		}
		
		return listaTelefones;
	}
	
	public EnderecoClienteVO consultarEnderecoClientePorId(Long idEndereco){
		
		EnderecoClienteVO enderecoCliente = null;
		
		try {
			
			enderecoCliente = dao.consultarEnderecoClientePorId(idEndereco);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			enderecoCliente = null;
		}
		
		return enderecoCliente;
	}
	
	public TelefoneClienteVO consultarTelefoneClientePorId(Long idTelefone){
		
		TelefoneClienteVO telefoneCliente = null;
		
		try {
			
			telefoneCliente = dao.consultarTelefoneClientePorId(idTelefone);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			telefoneCliente = null;
		}
		
		return telefoneCliente;
	}
	
	public boolean excluirCliente(ClienteVO cliente){
		
		try {
			
			dao.excluirCliente(cliente);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			return false;
		}
		
		return true;
	}
	
	
	public boolean excluirEnderecoCliente(EnderecoClienteVO endereco){
		
		try {
			
			dao.excluirEnderecoCliente(endereco);
		} catch (Exception e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
			return false;
		}
		
		return true;
	}
	
	
	public boolean excluirTelefoneCliente(TelefoneClienteVO telefone){
		
		try {
			
			dao.excluirTelefoneCliente(telefone);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean incluir(ClienteVO cliente) {
		
		try {
			
			dao.incluir(cliente);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			return false;
		}
		
		return true;
	}
	
	
	public List<CidadeVO> consultarCidadePorEstado(Long idEstado){
		
		List<CidadeVO> listaCidades = null;
		
		try {
			listaCidades = cidade.consultarCidadePorEstado(idEstado);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			listaCidades = null;
		}
		
		
		return listaCidades;
	}
	
	public List<EstadoVO> consultarTodosEstados(){
		
		List<EstadoVO> listaEstados = null;
		
		try {
			listaEstados = estado.consultarTodos();
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			
			listaEstados = null;
		}
		
		return listaEstados;
	}
	
	public JSONArray converterListaCidadesJson(List<CidadeVO> listaCidades){
		
		JSONArray vetorCidades = new JSONArray();
		
		for (CidadeVO cidade : listaCidades) {
			
			JSONObject jsonCidade = new JSONObject();
			
			jsonCidade.put("idCidade", cidade.getIdCidade());
			jsonCidade.put("nomeCidade", cidade.getNomeCidade());
			
			vetorCidades.add(jsonCidade);
		}
		
		
		return vetorCidades;
	}

	public boolean isComboCidadeInvalido(String cidade){
		
		return UtilFuncoes.isCampoComboValido(cidade);
	}
	
	public boolean isTamanhoTelefoneValido (String telefone){
		
		return UtilFuncoes.validarTamanhoMaximoTelefone(telefone);
	}
	
	public boolean isTamanhoDddValido(String ddd){
		
		return UtilFuncoes.validarTamanhoMaximoDDD(ddd);
	}
	
	public boolean isTamanhoEmailValido(String email){
		
		return UtilFuncoes.validarTamanhoMaximoEmail(email);
	}
	

}
