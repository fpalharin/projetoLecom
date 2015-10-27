package br.lecom.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.BusyConversationException;
import javax.inject.Qualifier;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import br.lecom.web.dao.service.IClienteDAO;
import br.lecom.web.vo.ClienteServicoVO;
import br.lecom.web.vo.ClienteVO;
import br.lecom.web.vo.EnderecoClienteVO;
import br.lecom.web.vo.ServicoEmpresaVO;
import br.lecom.web.vo.TelefoneClienteVO;



public class ClienteDAOImpl extends EntityDAOImpl<ClienteVO, Long> implements IClienteDAO{

	@PersistenceContext(unitName="ProjetoLecom")
	private EntityManager em;
	
	@Resource
	private UserTransaction userTransaction;
	
	public ClienteDAOImpl() {
		super(ClienteVO.class);
	}
	

	@Override
	public List<ClienteVO> consultarClientePorNome(String nomeCliente)throws Exception {
		 userTransaction.begin();
		 	
		 	Query query = em.createNamedQuery("queryBuscarClientePorNome");
		 	
		 	query.setParameter("nomeCliente", "%"+nomeCliente.toLowerCase()+"%");
		 	
		 	List<ClienteVO> listaClientes = query.getResultList();
		 
		 userTransaction.commit();
		 
		return listaClientes;
	}

	@Override
	public ClienteVO consultarClientePorCpf(String cpfCliente)throws Exception {
		
		userTransaction.begin();
		
			Query query = em.createNamedQuery("queryBuscarClientePorCpf");
			
			query.setParameter("cpfCliente", cpfCliente);
			
			ClienteVO cliente = (ClienteVO) query.getSingleResult();
		
		
		userTransaction.commit();
		
		return cliente;
	}

	@Override
	public ClienteVO detalharCliente(Long idCliente) throws Exception {
		
		ClienteVO cliente = new ClienteVO();
		
		try{
			
			cliente.setListaTelefones(consultarTelefoneClientePorIdCliente(idCliente));
			cliente.setListaEnderecos(consultarEnderecoClientePorIdCliente(idCliente));
			
		}
		catch(NoResultException e){
			
			cliente = null;
		}
		
		return cliente;
	}
	
	@Override
	public void alterar(ClienteVO cliente) throws Exception {
		userTransaction.begin();
		
		List<EnderecoClienteVO> listaEnderecoAuxInc = cliente.getListaEnderecoAuxInc();
		List<EnderecoClienteVO> listaEnderecoAuxExc = cliente.getListaEnderecoAuxExc();
		List<TelefoneClienteVO> listaTelefoneAuxInc = cliente.getListaTelefoneAuxInc();
		List<TelefoneClienteVO> listaTelefoneAuxExc = cliente.getListaTelefoneAuxExc();
		
		em.merge(cliente);
		
		excluirEnderecoAux(listaEnderecoAuxExc);
		incluirEnderecoAux(listaEnderecoAuxInc);
		excluirTelefoneAux(listaTelefoneAuxExc);
		incluirTelefoneAux(listaTelefoneAuxInc);
		
		userTransaction.commit();

	}
	
	private void excluirEnderecoAux(List<EnderecoClienteVO> listaEnderecos) throws Exception{
		
		for (EnderecoClienteVO enderecoCliente : listaEnderecos) {
			
			if(enderecoCliente.getIdEnderecoCliente() != null){
				
				EnderecoClienteVO enderecoExclusao = em.find(EnderecoClienteVO.class, enderecoCliente.getIdEnderecoCliente());
				
				em.remove(enderecoExclusao);
			}
		}
	}
	
	private void incluirEnderecoAux(List<EnderecoClienteVO> listaEnderecos) throws Exception{
		if(listaEnderecos != null){
			
			for (EnderecoClienteVO enderecoCliente : listaEnderecos) {
				
				em.persist(enderecoCliente);
			}
		}	
	}
	
	private void excluirTelefoneAux(List<TelefoneClienteVO> listaTelefones) throws Exception{
		
		for (TelefoneClienteVO telefoneCliente : listaTelefones) {
			
			if(telefoneCliente.getIdTelefoneCliente() != null){
				
				TelefoneClienteVO telefoneExclusao = em.find(TelefoneClienteVO.class, telefoneCliente.getIdTelefoneCliente());
				
				em.remove(telefoneExclusao);
			}
		}
	}
	
	private void incluirTelefoneAux(List<TelefoneClienteVO> listaTelefones) throws Exception{
		if(listaTelefones != null){
			
			for (TelefoneClienteVO telefoneCliente : listaTelefones) {
				
				em.persist(telefoneCliente);
			}
		}	
	}

	@Override
	public boolean alterarEnderecoCliente(EnderecoClienteVO endereco)throws Exception {
		
		userTransaction.begin();
		
			em.merge(endereco);
		
		userTransaction.commit();
		
		return true;
	}

	@Override
	public boolean alterarTelefoneCliente(TelefoneClienteVO telefone)throws Exception {
		
		userTransaction.begin();
		
			em.merge(telefone);
		
		userTransaction.commit();
		
		
		return true;
	}

	@Override
	public List<EnderecoClienteVO> consultarEnderecoClientePorIdCliente(Long idCliente) throws Exception {
		
		List<EnderecoClienteVO> listaEnderecos = null;
		
		try{
			
		userTransaction.begin();
			
			Query query = em.createNamedQuery("queryBuscarEnderecoPorIdCliente");
			
			query.setParameter("idCliente", idCliente);
			
			listaEnderecos = query.getResultList();
		
		userTransaction.commit();
		
		}
		catch(NoResultException e){
			
			listaEnderecos = null;
		}
		return listaEnderecos;
	}

	@Override
	public List<TelefoneClienteVO> consultarTelefoneClientePorIdCliente(Long idCliente) throws Exception {
		
		List<TelefoneClienteVO> listaTelefones = null;
		
		try{
			
			userTransaction.begin();
			
				Query query = em.createNamedQuery("queryBuscarTelefonePorIdCliente");
				
				query.setParameter("idCliente", idCliente);
				
				listaTelefones = query.getResultList();
			
			userTransaction.commit();
			
		}
		catch(NoResultException e){
			
			listaTelefones = null;
		}
		
		return listaTelefones;
	}

	@Override
	public TelefoneClienteVO consultarTelefoneClientePorId(Long idTelefone)throws Exception {
		
		TelefoneClienteVO telefone = null;
		
		try{
			
			userTransaction.begin();
				
				Query query = em.createNamedQuery("queryBsucarTelefonePorId");
				query.setParameter("idTelefoneCliente", idTelefone);
				
				telefone = (TelefoneClienteVO) query.getSingleResult();
				
			userTransaction.commit();
			
		}
		catch(NoResultException e){
			
			telefone = null;
		}
		
		return telefone;
	}

	@Override
	public EnderecoClienteVO consultarEnderecoClientePorId(Long idEndereco)throws Exception {
		
		EnderecoClienteVO endereco = null;
		
		try{
			
			userTransaction.begin();
			
				Query query = em.createNamedQuery("queryBsucarEnderecoPorId");
				query.setParameter("idEnderecoCliente", idEndereco);
				
				endereco = (EnderecoClienteVO) query.getSingleResult();
			
			userTransaction.commit();
			
		}
		catch(NoResultException e){
			
			endereco = null;
		}
		
		return endereco;
	}

	@Override
	public boolean excluirCliente(ClienteVO cliente) throws Exception {
		
		userTransaction.begin();
			
			ClienteVO clinicaExclusao = em.find(ClienteVO.class, cliente.getIdCliente());
			
			em.remove(clinicaExclusao);
		
		userTransaction.commit();
		
		return true;
	}

	@Override
	public boolean excluirEnderecoCliente(EnderecoClienteVO endereco)throws Exception {
		
		userTransaction.begin();
		
			EnderecoClienteVO enderecoExlcusao = em.find(EnderecoClienteVO.class, endereco.getIdEnderecoCliente());
			
			em.remove(enderecoExlcusao);
		
		userTransaction.commit();
		
		return true;
	}

	@Override
	public boolean excluirTelefoneCliente(TelefoneClienteVO telefone)throws Exception {
		
		userTransaction.begin();
		
			TelefoneClienteVO telefoneExclusao = em.find(TelefoneClienteVO.class, telefone.getIdTelefoneCliente());
		
			em.remove(telefoneExclusao);
		
		userTransaction.commit();
		
		return true;
	}
	
	@Override
	public void incluir(ClienteVO cliente) throws Exception {
		
		userTransaction.begin();
		
			em.persist(cliente);
		
		userTransaction.commit();
		
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
	public List<ClienteServicoVO> consultarServicosPorCliente(Long idCliente)throws Exception {
		
			List<ClienteServicoVO> listaClienteServico = null;
			
			try{
				userTransaction.begin();
					
					Query query = em.createNamedQuery("queryBuscarServicoPorCliente");
					query.setParameter("idCliente", idCliente);
					
					listaClienteServico = query.getResultList();
				
				userTransaction.commit();
			}
			catch(NoResultException e){
				
				listaClienteServico = null;
			}
			
			return listaClienteServico;
	}


}
