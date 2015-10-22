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

public class ClienteDAOImpl extends EntityDAOImpl<ClienteVO, Double> implements IClienteDAO{

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
	public ClienteVO detalharCliente(Double idCliente) throws Exception {
		
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
		
			em.merge(cliente);
		
		userTransaction.commit();

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
	public List<EnderecoClienteVO> consultarEnderecoClientePorIdCliente(Double idCliente) throws Exception {
		
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
	public List<TelefoneClienteVO> consultarTelefoneClientePorIdCliente(Double idCliente) throws Exception {
		
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
	public TelefoneClienteVO consultarTelefoneClientePorId(Double idTelefone)throws Exception {
		
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
	public EnderecoClienteVO consultarEnderecoClientePorId(Double idEndereco)throws Exception {
		
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
			
			em.remove(cliente);
		
		userTransaction.commit();
		
		return true;
	}

	@Override
	public boolean excluirEnderecoCliente(EnderecoClienteVO endereco)throws Exception {
		
		userTransaction.begin();
			
			em.remove(endereco);
		
		userTransaction.commit();
		
		return true;
	}

	@Override
	public boolean excluirTelefoneCliente(TelefoneClienteVO telefone)throws Exception {
		
		userTransaction.begin();
		
			em.remove(telefone);
		
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
	public List<ClienteServicoVO> consultarServicosPorCliente(Double idCliente)throws Exception {
		
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
