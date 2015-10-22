package br.lecom.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;
import br.lecom.web.bo.impl.ClienteBO;
import br.lecom.web.constraint.service.Cep;
import br.lecom.web.constraint.service.Cpf;
import br.lecom.web.constraint.service.EmptyComboBox;
import br.lecom.web.constraint.service.EmptyField;
import br.lecom.web.constraint.service.Rg;
import br.lecom.web.enumeradores.TipoAcesso;
import br.lecom.web.vo.CidadeVO;
import br.lecom.web.vo.ClienteVO;
import br.lecom.web.vo.EnderecoClienteVO;
import br.lecom.web.vo.EstadoVO;
import br.lecom.web.vo.TelefoneClienteVO;
import br.lecom.web.util.UtilFuncoes;


@Named("cliente")
@ViewScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Atributos da Inclusão de Cliente
	@EmptyField
	@Size(max=50, message="O campo é obrigatório")
	private String nomeClienteInc;
	
	@EmptyField
	@Rg
	private String rgClienteInc;
	
	@EmptyField
	@Size(max=30, message="O campo é obrigatório")
	private String emailClienteInc;
	
	@EmptyField
	@Cpf
	private String cpfClienteInc;
	
	@EmptyField
	private Long codClienteInc;
	
	@EmptyField
	@Size(max=2, message="O campo é obrigatório")
	private String dddClienteInc;
	
	@EmptyField
	@Size(max=9, message="O campo é obrigatório")
	private String telefoneClienteInc;
	
	@EmptyField
	@Size(max=20, message="O campo é obrigatório")
	private String tipoTelefone;
	
	private Double codEstadoInc;
	private List<SelectItem> listaEstadosInc;
	
	private Double codCidadeInc;
	private List<SelectItem> listaCidadesInc;
	
	@EmptyField
	@Size(max=100, message="O campo é obrigatório")
	private String logradouroClienteInc;
	
	@EmptyField
	@Size(max=100, message="O campo é obrigatório")
	private String bairroClienteInc;
	
	
	private String complementoClienteInc;
	
	@EmptyField
	@Cep
	private String cepClienteInc;
	
	//Bindings dos campos de Inclusão de Cliente
	private HtmlInputText campoNomeClienteInc;
	private HtmlInputText campoRgClienteInc;
	private HtmlInputText campoEmailClienteInc;
	private HtmlInputText campoCpfClienteInc;
	private HtmlInputText campoCodClienteInc;
	
	private HtmlInputText campoDddClienteInc;
	private HtmlInputText campoTelefoneClienteInc;
	private HtmlInputText campoTipoTelefoneInc;
	
	private HtmlInputText campoLogradouroClienteInc;
	private HtmlInputText campoBairroClienteInc;
	private HtmlInputText campoComplementoClienteInc;
	private HtmlInputText campoCepClienteInc;
	private HtmlSelectOneMenu campoEstadoInc;
	private HtmlSelectOneMenu campoCidadeInc;
	
	
	//Atributos da Alteração de Cliente
	private ClienteVO clienteSelecionadoAlt;
	
	@EmptyField
	@Size(max=50, message="O campo é obrigatório")
	private String nomeClienteAlt;
	
	@EmptyField
	@Rg
	private String rgClienteAlt;
	
	@EmptyField
	@Size(max=30, message="O campo é obrigatório")
	private String emailClienteAlt;
	
	@EmptyField
	@Cpf
	private String cpfClienteAlt;
	
	@EmptyField
	private Long codClienteAlt;
	
	
	//Bindings dos campos de Alteração de Cliente
	private HtmlInputText campoNomeClienteAlt;
	private HtmlInputText campoRgClienteAlt;
	private HtmlInputText campoEmailClienteAlt;
	private HtmlInputText campoCpfClienteAlt;
	private HtmlInputText campoCodClienteAlt;
	private ClienteVO clienteVODetalhe;
	
	//Atributos da Alteração de telefone
	private TelefoneClienteVO telefoneSelecionadoAlt;
	
	@EmptyField
	private String dddClienteAlt;
	
	@EmptyField
	private String telefoneClienteAlt;

	@EmptyField
	private String tipoTelefoneAlt;
	
	//Bindings dos campos de Alteração de Telefone
	private HtmlInputText campoDddClienteAlt;
	private HtmlInputText campoTelefoneClienteAlt;
	private HtmlInputText campoTipoTelefoneAlt;
	
	//Atributos da Alteração de endereço
	private EnderecoClienteVO enderecoSelecionadoAlt;
	
	@EmptyField
	@Size(max=100, message="O campo é obrigatório")
	private String logradouroClienteAlt;
	
	@EmptyField
	@Size(max=100, message="O campo é obrigatório")
	private String bairroClienteAlt;
	
	
	private String complementoClienteAlt;
	
	@EmptyField
	@Cep
	private String cepClienteAlt;
	
	private Double codEstadoAlt;
	private List<SelectItem> listaEstadosAlt;
	
	@EmptyComboBox
	private Double codCidadeAlt;
	private List<SelectItem> listaCidadesAlt;
	
	//Bindings dos campos de Alteração de Endereço
	private HtmlInputText campoLogradouroClienteAlt;
	private HtmlInputText campoBairroClienteAlt;
	private HtmlInputText campoComplementoClienteAlt;
	private HtmlInputText campoCepClienteAlt;
	private HtmlSelectOneMenu campoCidadeAlt;
	private HtmlSelectOneMenu campoEstadoAlt;
	
	//Atributos da Exclusão de Cliente
	private ClienteVO clienteRecebidoEx;
	private EnderecoClienteVO enderecoRecebidoEx;
	private TelefoneClienteVO telefoneRecebidoEx;
	
	//Atributos da tela de Consulta de Cliente
	private String nomeClienteCon;
	private List<ClienteVO> listaClientesCon;
	private ClienteVO clienteSelecionadoCon;
	private List<TelefoneClienteVO> listaTelefonesCon;
	private List<EnderecoClienteVO> listaEnderecosCon;
	
	//Exclusão e Inclusão de Endereco AUX
	private List<EnderecoClienteVO> listaEnderecoAuxInc;
	private List<EnderecoClienteVO> listaEnderecoAuxEx;
	private List<EnderecoClienteVO> listaDialogEndereco;
	private String logradouroClienteAux;
	private String bairroClienteAux;
	private String complementoClienteAux;
	private String cepClienteAux;
	private Double codEstadoAux;
	private List<SelectItem> listaEstadosAux;
	private Double codCidadeAux;
	private List<SelectItem> listaCidadesAux;
	private HtmlSelectOneMenu campoCidadeAux;
	
	//Exclusão e Inclusão de Telefone AUX
	private List<TelefoneClienteVO> listaTelefoneAuxInc;
	private List<TelefoneClienteVO> listaTelefoneAuxEx;
	private List<TelefoneClienteVO> listaDialogTelefone;
	private String dddClienteAux;
	private String telefoneClienteAux;
	private String tipoTelefoneAux;
	
	private Double idClienteAlt;
	
	@Inject
	private ClienteBO bo;
	
	public void salvarEnderecoAux(){
		
		EnderecoClienteVO endereco = new EnderecoClienteVO();
		
		EstadoVO estado = null;
		CidadeVO cidade = null;
		
		for(SelectItem si : listaEstadosAux){
			
			if(si.getValue().equals(codEstadoAux)){
				
				estado = new EstadoVO();
				estado.setIdEstado((Double) si.getValue());
				estado.setNomeEstado(si.getLabel());
			}
		}
		
		for(SelectItem si : listaCidadesAux){
			
			if(si.getValue().equals(codCidadeAux)){
				
				cidade = new CidadeVO();
				cidade.setIdCidade((Double) si.getValue());
				cidade.setNomeCidade(si.getLabel());
			}
		}
		
		endereco.setBairroCliente(bairroClienteAux);
		endereco.setCepCliente(cepClienteAux);
		endereco.setComplementoCliente(complementoClienteAux);
		endereco.setLogradouroCliente(logradouroClienteAux);
		endereco.setCidade(cidade);
		endereco.getCidade().setEstado(estado);
		endereco.setCliente(new ClienteVO());
		endereco.getCliente().setIdCliente(idClienteAlt);
		
		listaEnderecoAuxInc.add(endereco);
		listaDialogEndereco.add(endereco);
		
		bairroClienteAux = null;
		cepClienteAux = null;
		complementoClienteAux = null;
		logradouroClienteAux = null;
		codEstadoAux = 0d;
		codCidadeAux = 0d;
		
	}
	
	public void excluirEnderecoAux(EnderecoClienteVO endereco){
		
		listaEnderecoAuxEx.add(endereco);
		listaEnderecoAuxInc.remove(endereco);
		listaDialogEndereco.remove(endereco);
		
	}
	
	public void salvarTelefoneAux(){
		TelefoneClienteVO telefone = new TelefoneClienteVO();
		
		telefone.setDddCliente(dddClienteAux);
		telefone.setTelefoneCliente(telefoneClienteAux);
		telefone.setTipoTelefone(tipoTelefoneAux);
		telefone.setCliente(new ClienteVO());
		telefone.getCliente().setIdCliente(idClienteAlt);
		
		listaTelefoneAuxInc.add(telefone);
		listaDialogTelefone.add(telefone);
		
		dddClienteAux = null;
		telefoneClienteAux = null;
		tipoTelefoneAux = null;
	}
	
	public void excluirTelefoneAux(TelefoneClienteVO telefone){
		
		listaTelefoneAuxEx.add(telefone);
		listaTelefoneAuxInc.remove(telefone);
		listaDialogTelefone.remove(telefone);
	}
	
	public void pesquisarCliente(){
		
		this.listaClientesCon = bo.consultarClientePorNome(nomeClienteCon);
	}
	
	public void detalharCliente(){
		
		ClienteVO cliente = bo.detalharCliente(clienteSelecionadoCon.getIdCliente());

		listaTelefonesCon = cliente.getListaTelefones();
		listaEnderecosCon = cliente.getListaEnderecos();
	}
	
	public void buscarCidadePorEstado(AjaxBehaviorEvent evento){
		
		UIInput comboEstado = (UIInput) evento.getComponent();
		Double codEstado = (Double) comboEstado.getValue();
		
		listaCidadesInc = new ArrayList<SelectItem>();
		
		if(!codEstado.equals(0L)){
			
			List<CidadeVO> listaCidades = bo.consultarCidadePorEstado(codEstado);
			
			for (CidadeVO cidade : listaCidades) {
				
				listaCidadesInc.add(new SelectItem(cidade.getIdCidade(), cidade.getNomeCidade()));
			}
			
			this.campoCidadeInc.setDisabled(false);
		}
		
	}
	
	public void buscarCidadePorEstadoAux(AjaxBehaviorEvent evento){
		
		UIInput comboEstado = (UIInput) evento.getComponent();
		Double codEstado = (Double) comboEstado.getValue();
		
		listaCidadesAux = new ArrayList<SelectItem>();
		
		if(!codEstado.equals(0L)){
			
			List<CidadeVO> listaCidades = bo.consultarCidadePorEstado(codEstado);
			
			for (CidadeVO cidade : listaCidades) {
				
				listaCidadesAux.add(new SelectItem(cidade.getIdCidade(), cidade.getNomeCidade()));
			}
			
			this.campoCidadeAux.setDisabled(false);
		}
	}
	
	public void buscarCidadePorEstadoAlt(AjaxBehaviorEvent evento){
		
		UIInput comboEstado = (UIInput) evento.getComponent();
		Double codEstado = (Double) comboEstado.getValue();
		
		listaCidadesAlt = new ArrayList<SelectItem>();
		
		if(!codEstado.equals(0L)){
			
			List<CidadeVO> listaCidades = bo.consultarCidadePorEstado(codEstado);
			
			for (CidadeVO cidade : listaCidades) {
				
				listaCidadesAlt.add(new SelectItem(cidade.getIdCidade(), cidade.getNomeCidade()));
			}
			
			this.campoCidadeAlt.setDisabled(false);
		}
		
	}
	
	@PostConstruct
	public void incializarTela() throws IOException{
		
		codCidadeInc = 0D;
		String action = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(UtilFuncoes.PARAM_ENTRADA);
		
		if(action != null){
			
			if(action.trim().equals(TipoAcesso.INCLUIR.getAcesso())){
				
				List<EstadoVO> listaEstados = bo.consultarTodosEstados();
				listaEstadosInc = new ArrayList<SelectItem>();
				
				for (EstadoVO estado : listaEstados) {
					
					listaEstadosInc.add(new SelectItem(estado.getIdEstado(), estado.getNomeEstado()));
				}
			}
			else if(action.trim().equals(TipoAcesso.CONSULTAR.getAcesso())) {
				
			}
			else if(action.trim().equals(TipoAcesso.ALTERAR.getAcesso())){
				
				String idClienteTexto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCliente");
				idClienteAlt = Double.parseDouble(idClienteTexto);
				
				listaDialogEndereco = bo.consultarEnderecoClientePorIdCliente(idClienteAlt);
				listaDialogTelefone = bo.consultarTelefoneClientePorIdCliente(idClienteAlt);
				
				List<EstadoVO> listaEstados = bo.consultarTodosEstados();
				listaEstadosAux = new ArrayList<SelectItem>();
				
				for (EstadoVO estado : listaEstados) {
					
					listaEstadosAux.add(new SelectItem(estado.getIdEstado(), estado.getNomeEstado()));
				}
				
				listaEnderecoAuxInc = new ArrayList<EnderecoClienteVO>();
				listaEnderecoAuxEx = new ArrayList<EnderecoClienteVO>();
				listaTelefoneAuxInc = new ArrayList<TelefoneClienteVO>();
				listaTelefoneAuxEx = new ArrayList<TelefoneClienteVO>();
				
				clienteSelecionadoAlt = bo.consultarPorId(idClienteAlt);
				
				nomeClienteAlt = clienteSelecionadoAlt.getNomeCliente();
				rgClienteAlt = clienteSelecionadoAlt.getRgCliente();
				emailClienteAlt = clienteSelecionadoAlt.getEmailCliente();
				cpfClienteAlt = clienteSelecionadoAlt.getCpfCliente();
				codClienteAlt = clienteSelecionadoAlt.getCodCliente();
				
			}
			else if(action.trim().equals(TipoAcesso.CONSULTAR_ALTERAR.getAcesso())){
				
				listaClientesCon = bo.consultarClientePorNome(" ");
			}
			else if(action.trim().equals(TipoAcesso.ALTERAR_ENDERECO.getAcesso())){
				
				String idEnderecoTexto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idEndereco");
				Double idEndereco = Double.parseDouble(idEnderecoTexto);
				
				enderecoSelecionadoAlt = bo.consultarEnderecoClientePorId(idEndereco);
				logradouroClienteAlt = enderecoSelecionadoAlt.getLogradouroCliente();
				bairroClienteAlt = enderecoSelecionadoAlt.getBairroCliente();
				complementoClienteAlt = enderecoSelecionadoAlt.getComplementoCliente();
				cepClienteAlt = enderecoSelecionadoAlt.getCepCliente();
				codCidadeAlt = enderecoSelecionadoAlt.getCidade().getIdCidade();
				codEstadoAlt = enderecoSelecionadoAlt.getCidade().getEstado().getIdEstado();
				clienteVODetalhe = enderecoSelecionadoAlt.getCliente();
				
				List<EstadoVO> listaEstados = bo.consultarTodosEstados();
				listaEstadosAlt =  new ArrayList<SelectItem>();
				
				for (EstadoVO estado : listaEstados) {
					
					listaEstadosAlt.add(new SelectItem(estado.getIdEstado(), estado.getNomeEstado()));
				}
				
				List<CidadeVO> listaCidades = bo.consultarCidadePorEstado(codEstadoAlt);
				listaCidadesAlt = new ArrayList<SelectItem>();
				
				for (CidadeVO cidade : listaCidades) {
					
					listaCidadesAlt.add(new SelectItem(cidade.getIdCidade(), cidade.getNomeCidade()));
				}
				
			}
			else if(action.trim().equals(TipoAcesso.ALTERAR_TELEFONE.getAcesso())){
				
				String idTelefoneTexto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTelefone");
				Double idTelefone = Double.parseDouble(idTelefoneTexto);
				
				telefoneSelecionadoAlt = bo.consultarTelefoneClientePorId(idTelefone);
				dddClienteAlt = telefoneSelecionadoAlt.getDddCliente();
				telefoneClienteAlt = telefoneSelecionadoAlt.getTelefoneCliente();
				tipoTelefoneAlt = telefoneSelecionadoAlt.getTipoTelefone();
				clienteVODetalhe = telefoneSelecionadoAlt.getCliente();
			}
			else{
				
				FacesContext.getCurrentInstance().getExternalContext().redirect(
					FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
					+ "/jsf-pages/erros/erro404.html");
			}
			
		}
		else{
			
			FacesContext.getCurrentInstance().getExternalContext().redirect(
				FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+ "/jsf-pages/erros/erro404.html");
		}
		
	}
	
	public void limparFormulario(){
		
		campoNomeClienteInc.setSubmittedValue("");
		campoRgClienteInc.setSubmittedValue("");
		campoEmailClienteInc.setSubmittedValue("");
		campoCpfClienteInc.setSubmittedValue("");
		campoCodClienteInc.setSubmittedValue("");
		
		campoDddClienteInc.setSubmittedValue("");
		campoTelefoneClienteInc.setSubmittedValue("");
		campoTipoTelefoneInc.setSubmittedValue("");
		
		campoLogradouroClienteInc.setSubmittedValue("");
		campoBairroClienteInc.setSubmittedValue("");
		campoComplementoClienteInc.setSubmittedValue("");
		campoCepClienteInc.setSubmittedValue("");
		campoEstadoInc.setSubmittedValue(0);
		campoCidadeInc.setSubmittedValue(0);
		campoCidadeInc.setDisabled(true);
	}
	
	public String alterarCliente(){
		ClienteVO cliente = new ClienteVO();
		
		cliente.setIdCliente(clienteSelecionadoAlt.getIdCliente());
		cliente.setNomeCliente(nomeClienteAlt);
		cliente.setRgCliente(rgClienteAlt);
		cliente.setEmailCliente(emailClienteAlt);
		cliente.setCpfCliente(cpfClienteAlt);
		cliente.setCodCliente(codClienteAlt);
		
		cliente.setListaEnderecoAuxExc(listaEnderecoAuxEx);
		cliente.setListaEnderecoAuxInc(listaEnderecoAuxInc);
		cliente.setListaTelefoneAuxExc(listaTelefoneAuxEx);
		cliente.setListaTelefoneAuxInc(listaTelefoneAuxInc);
		
		bo.alterar(cliente);
		
		return UtilFuncoes.PATH_RETORNO;
	}
	
	public void limparFormularioAlterar(){
		
		campoNomeClienteAlt.setSubmittedValue("");
		campoRgClienteAlt.setSubmittedValue("");
		campoEmailClienteAlt.setSubmittedValue("");
		campoCpfClienteAlt.setSubmittedValue("");
		campoCodClienteAlt.setSubmittedValue("");
	}
	
	public void receberIdCliente(ClienteVO cliente){
		
		this.clienteRecebidoEx = cliente;
	}
	
	public void excluirCliente(){
		
		bo.excluirCliente(this.clienteRecebidoEx);
		
		listaClientesCon = bo.consultarClientePorNome("");
	}
	
	public String alterarEndereco(){
		
		EnderecoClienteVO endereco = new EnderecoClienteVO();
		
		endereco.setIdEnderecoCliente(enderecoSelecionadoAlt.getIdEnderecoCliente());
		endereco.setBairroCliente(bairroClienteAlt);
		endereco.setCepCliente(cepClienteAlt);
		endereco.setComplementoCliente(complementoClienteAlt);
		endereco.setLogradouroCliente(logradouroClienteAlt);
		endereco.setCidade(new CidadeVO());
		endereco.getCidade().setIdCidade(codCidadeAlt);
		endereco.setCliente(clienteVODetalhe);
		
		bo.alterarEnderecoCliente(endereco);
		
		return UtilFuncoes.PATH_RETORNO;
	}
	
	public void limparFormularioAlterarEndereco(){

		campoLogradouroClienteAlt.setSubmittedValue("");
		campoBairroClienteAlt.setSubmittedValue("");
		campoComplementoClienteAlt.setSubmittedValue("");
		campoCepClienteAlt.setSubmittedValue("");
		campoCidadeAlt.setSubmittedValue(0);
		campoEstadoAlt.setSubmittedValue(0);
	}
	
	public void receberIdEndereco(EnderecoClienteVO endereco){
		
		this.enderecoRecebidoEx = endereco;
	}
	
	public void excluirEndereco(){
		
		bo.excluirEnderecoCliente(this.enderecoRecebidoEx);
		
		listaEnderecosCon = bo.consultarEnderecoClientePorIdCliente(clienteSelecionadoCon.getIdCliente());
	}
	
	public String alterarTelefone(){
		
		TelefoneClienteVO telefone = new TelefoneClienteVO();
		
		telefone.setIdTelefoneCliente(telefoneSelecionadoAlt.getIdTelefoneCliente());
		telefone.setDddCliente(dddClienteAlt);
		telefone.setTelefoneCliente(telefoneClienteAlt);
		telefone.setTipoTelefone(tipoTelefoneAlt);
		telefone.setCliente(clienteVODetalhe);
		
		bo.alterarTelefoneCliente(telefone);
		
		return UtilFuncoes.PATH_RETORNO;
	}
	
	public void limparFormularioTelefone(){
		
		campoDddClienteAlt.setSubmittedValue("");
		campoTelefoneClienteAlt.setSubmittedValue("");
		campoTipoTelefoneAlt.setSubmittedValue("");
		
	}
	
	public void receberIdTelefone(TelefoneClienteVO telefone){
		
		this.telefoneRecebidoEx = telefone;
	}
	
	public void excluirTelefone(){
		
		bo.excluirTelefoneCliente(telefoneRecebidoEx);
		
		listaTelefonesCon = bo.consultarTelefoneClientePorIdCliente(clienteSelecionadoCon.getIdCliente());
	}
	
	public void salvarCliente(){
		
		boolean flagSucesso = true;
		
		if(!bo.isTamanhoEmailValido(emailClienteInc)){
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O tamanho máximo do campo de email é de 30 caracteres", ""));
			
			flagSucesso = false;
		}
		
		if(!bo.isTamanhoTelefoneValido(telefoneClienteInc)){
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O tamanho máximo do campo de telefone é de 9 caracteres", ""));
			
			flagSucesso = false;
		}
		
		if(!bo.isTamanhoDddValido(dddClienteInc)){
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O tamanho máximo do campo de DDD é de 2 caracteres", ""));
			
			flagSucesso = false;
		}
		
		if(bo.isComboCidadeInvalido(codCidadeInc.toString())){
			
			FacesContext.getCurrentInstance().addMessage("formulario:comboCidade", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cidade não selecionada!", ""));
			
			flagSucesso = false;
		}
		
		if(flagSucesso){
			
			ClienteVO cliente = new ClienteVO();
			
			//Setando o Cliente
			cliente.setNomeCliente(nomeClienteInc);
			cliente.setRgCliente(rgClienteInc);
			cliente.setEmailCliente(emailClienteInc);
			cliente.setCpfCliente(cpfClienteInc);
			cliente.setCodCliente(codClienteInc);
			
			List<TelefoneClienteVO> listaTelefones = new ArrayList<TelefoneClienteVO>();
			List<EnderecoClienteVO> listaEnderecos = new ArrayList<EnderecoClienteVO>();
			
			//Setando o telefone
			TelefoneClienteVO telefone = new TelefoneClienteVO();
			
			telefone.setDddCliente(dddClienteInc);
			telefone.setTelefoneCliente(telefoneClienteInc);
			telefone.setTipoTelefone(tipoTelefone);
			telefone.setCliente(cliente);
			
			listaTelefones.add(telefone);
			
			cliente.setListaTelefones(listaTelefones);
			
			//Setando o endereco
			EnderecoClienteVO endereco = new EnderecoClienteVO();
			
			endereco.setBairroCliente(bairroClienteInc);
			endereco.setLogradouroCliente(logradouroClienteInc);
			endereco.setCepCliente(cepClienteInc);
			endereco.setComplementoCliente(complementoClienteInc);
			endereco.setCidade(new CidadeVO());
			endereco.getCidade().setIdCidade(codCidadeInc);
			
			listaEnderecos.add(endereco);
			
			cliente.setListaEnderecos(listaEnderecos);
			
			if(bo.incluir(cliente)){
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Incluido Com Sucesso", ""));
			}
			else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu uma falha no Banco", ""));

			}
		
		}
		
	}
	
	//Getters and Setters dos atributos
	public String getNomeClienteInc() {
		return nomeClienteInc;
	}

	public void setNomeClienteInc(String nomeClienteInc) {
		this.nomeClienteInc = nomeClienteInc;
	}

	public String getRgClienteInc() {
		return rgClienteInc;
	}

	public void setRgClienteInc(String rgClienteInc) {
		this.rgClienteInc = rgClienteInc;
	}

	public String getEmailClienteInc() {
		return emailClienteInc;
	}

	public void setEmailClienteInc(String emailClienteInc) {
		this.emailClienteInc = emailClienteInc;
	}

	public String getCpfClienteInc() {
		return cpfClienteInc;
	}

	public void setCpfClienteInc(String cpfClienteInc) {
		this.cpfClienteInc = cpfClienteInc;
	}

	public Long getCodClienteInc() {
		return codClienteInc;
	}

	public void setCodClienteInc(Long codClienteInc) {
		this.codClienteInc = codClienteInc;
	}

	public String getDddClienteInc() {
		return dddClienteInc;
	}

	public void setDddClienteInc(String dddClienteInc) {
		this.dddClienteInc = dddClienteInc;
	}

	public String getTelefoneClienteInc() {
		return telefoneClienteInc;
	}

	public void setTelefoneClienteInc(String telefoneClienteInc) {
		this.telefoneClienteInc = telefoneClienteInc;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public Double getCodEstadoInc() {
		return codEstadoInc;
	}

	public void setCodEstadoInc(Double codEstadoInc) {
		this.codEstadoInc = codEstadoInc;
	}

	public List<SelectItem> getListaEstadosInc() {
		return listaEstadosInc;
	}

	public void setListaEstadosInc(List<SelectItem> listaEstadosInc) {
		this.listaEstadosInc = listaEstadosInc;
	}

	public Double getCodCidadeInc() {
		return codCidadeInc;
	}

	public void setCodCidadeInc(Double codCidadeInc) {
		this.codCidadeInc = codCidadeInc;
	}

	public List<SelectItem> getListaCidadesInc() {
		return listaCidadesInc;
	}

	public void setListaCidadesInc(List<SelectItem> listaCidadesInc) {
		this.listaCidadesInc = listaCidadesInc;
	}

	public String getLogradouroClienteInc() {
		return logradouroClienteInc;
	}

	public void setLogradouroClienteInc(String logradouroClienteInc) {
		this.logradouroClienteInc = logradouroClienteInc;
	}

	public String getBairroClienteInc() {
		return bairroClienteInc;
	}

	public void setBairroClienteInc(String bairroClienteInc) {
		this.bairroClienteInc = bairroClienteInc;
	}

	public String getComplementoClienteInc() {
		return complementoClienteInc;
	}

	public void setComplementoClienteInc(String complementoClienteInc) {
		this.complementoClienteInc = complementoClienteInc;
	}

	public String getCepClienteInc() {
		return cepClienteInc;
	}

	public void setCepClienteInc(String cepClienteInc) {
		this.cepClienteInc = cepClienteInc;
	}

	public HtmlInputText getCampoNomeClienteInc() {
		return campoNomeClienteInc;
	}

	public void setCampoNomeClienteInc(HtmlInputText campoNomeClienteInc) {
		this.campoNomeClienteInc = campoNomeClienteInc;
	}

	public HtmlInputText getCampoRgClienteInc() {
		return campoRgClienteInc;
	}

	public void setCampoRgClienteInc(HtmlInputText campoRgClienteInc) {
		this.campoRgClienteInc = campoRgClienteInc;
	}

	public HtmlInputText getCampoEmailClienteInc() {
		return campoEmailClienteInc;
	}

	public void setCampoEmailClienteInc(HtmlInputText campoEmailClienteInc) {
		this.campoEmailClienteInc = campoEmailClienteInc;
	}

	public HtmlInputText getCampoCpfClienteInc() {
		return campoCpfClienteInc;
	}

	public void setCampoCpfClienteInc(HtmlInputText campoCpfClienteInc) {
		this.campoCpfClienteInc = campoCpfClienteInc;
	}

	public HtmlInputText getCampoCodClienteInc() {
		return campoCodClienteInc;
	}

	public void setCampoCodClienteInc(HtmlInputText campoCodClienteInc) {
		this.campoCodClienteInc = campoCodClienteInc;
	}

	public HtmlInputText getCampoDddClienteInc() {
		return campoDddClienteInc;
	}

	public void setCampoDddClienteInc(HtmlInputText campoDddClienteInc) {
		this.campoDddClienteInc = campoDddClienteInc;
	}

	public HtmlInputText getCampoTelefoneClienteInc() {
		return campoTelefoneClienteInc;
	}

	public void setCampoTelefoneClienteInc(HtmlInputText campoTelefoneClienteInc) {
		this.campoTelefoneClienteInc = campoTelefoneClienteInc;
	}

	public HtmlInputText getCampoTipoTelefoneInc() {
		return campoTipoTelefoneInc;
	}

	public void setCampoTipoTelefoneInc(HtmlInputText campoTipoTelefoneInc) {
		this.campoTipoTelefoneInc = campoTipoTelefoneInc;
	}

	public HtmlInputText getCampoLogradouroClienteInc() {
		return campoLogradouroClienteInc;
	}

	public void setCampoLogradouroClienteInc(HtmlInputText campoLogradouroClienteInc) {
		this.campoLogradouroClienteInc = campoLogradouroClienteInc;
	}

	public HtmlInputText getCampoBairroClienteInc() {
		return campoBairroClienteInc;
	}

	public void setCampoBairroClienteInc(HtmlInputText campoBairroClienteInc) {
		this.campoBairroClienteInc = campoBairroClienteInc;
	}

	public HtmlInputText getCampoComplementoClienteInc() {
		return campoComplementoClienteInc;
	}

	public void setCampoComplementoClienteInc(
			HtmlInputText campoComplementoClienteInc) {
		this.campoComplementoClienteInc = campoComplementoClienteInc;
	}

	public HtmlInputText getCampoCepClienteInc() {
		return campoCepClienteInc;
	}

	public void setCampoCepClienteInc(HtmlInputText campoCepClienteInc) {
		this.campoCepClienteInc = campoCepClienteInc;
	}

	public HtmlSelectOneMenu getCampoEstadoInc() {
		return campoEstadoInc;
	}

	public void setCampoEstadoInc(HtmlSelectOneMenu campoEstadoInc) {
		this.campoEstadoInc = campoEstadoInc;
	}

	public HtmlSelectOneMenu getCampoCidadeInc() {
		return campoCidadeInc;
	}

	public void setCampoCidadeInc(HtmlSelectOneMenu campoCidadeInc) {
		this.campoCidadeInc = campoCidadeInc;
	}

	public ClienteVO getClienteSelecionadoAlt() {
		return clienteSelecionadoAlt;
	}

	public void setClienteSelecionadoAlt(ClienteVO clienteSelecionadoAlt) {
		this.clienteSelecionadoAlt = clienteSelecionadoAlt;
	}

	public String getNomeClienteAlt() {
		return nomeClienteAlt;
	}

	public void setNomeClienteAlt(String nomeClienteAlt) {
		this.nomeClienteAlt = nomeClienteAlt;
	}

	public String getRgClienteAlt() {
		return rgClienteAlt;
	}

	public void setRgClienteAlt(String rgClienteAlt) {
		this.rgClienteAlt = rgClienteAlt;
	}

	public String getEmailClienteAlt() {
		return emailClienteAlt;
	}

	public void setEmailClienteAlt(String emailClienteAlt) {
		this.emailClienteAlt = emailClienteAlt;
	}

	public String getCpfClienteAlt() {
		return cpfClienteAlt;
	}

	public void setCpfClienteAlt(String cpfClienteAlt) {
		this.cpfClienteAlt = cpfClienteAlt;
	}

	public Long getCodClienteAlt() {
		return codClienteAlt;
	}

	public void setCodClienteAlt(Long codClienteAlt) {
		this.codClienteAlt = codClienteAlt;
	}

	public HtmlInputText getCampoNomeClienteAlt() {
		return campoNomeClienteAlt;
	}

	public void setCampoNomeClienteAlt(HtmlInputText campoNomeClienteAlt) {
		this.campoNomeClienteAlt = campoNomeClienteAlt;
	}

	public HtmlInputText getCampoRgClienteAlt() {
		return campoRgClienteAlt;
	}

	public void setCampoRgClienteAlt(HtmlInputText campoRgClienteAlt) {
		this.campoRgClienteAlt = campoRgClienteAlt;
	}

	public HtmlInputText getCampoEmailClienteAlt() {
		return campoEmailClienteAlt;
	}

	public void setCampoEmailClienteAlt(HtmlInputText campoEmailClienteAlt) {
		this.campoEmailClienteAlt = campoEmailClienteAlt;
	}

	public HtmlInputText getCampoCpfClienteAlt() {
		return campoCpfClienteAlt;
	}

	public void setCampoCpfClienteAlt(HtmlInputText campoCpfClienteAlt) {
		this.campoCpfClienteAlt = campoCpfClienteAlt;
	}

	public HtmlInputText getCampoCodClienteAlt() {
		return campoCodClienteAlt;
	}

	public void setCampoCodClienteAlt(HtmlInputText campoCodClienteAlt) {
		this.campoCodClienteAlt = campoCodClienteAlt;
	}

	public ClienteVO getClienteVODetalhe() {
		return clienteVODetalhe;
	}

	public void setClienteVODetalhe(ClienteVO clienteVODetalhe) {
		this.clienteVODetalhe = clienteVODetalhe;
	}

	public TelefoneClienteVO getTelefoneSelecionadoAlt() {
		return telefoneSelecionadoAlt;
	}

	public void setTelefoneSelecionadoAlt(TelefoneClienteVO telefoneSelecionadoAlt) {
		this.telefoneSelecionadoAlt = telefoneSelecionadoAlt;
	}

	public String getDddClienteAlt() {
		return dddClienteAlt;
	}

	public void setDddClienteAlt(String dddClienteAlt) {
		this.dddClienteAlt = dddClienteAlt;
	}

	public String getTelefoneClienteAlt() {
		return telefoneClienteAlt;
	}

	public void setTelefoneClienteAlt(String telefoneClienteAlt) {
		this.telefoneClienteAlt = telefoneClienteAlt;
	}

	public String getTipoTelefoneAlt() {
		return tipoTelefoneAlt;
	}

	public void setTipoTelefoneAlt(String tipoTelefoneAlt) {
		this.tipoTelefoneAlt = tipoTelefoneAlt;
	}

	public HtmlInputText getCampoDddClienteAlt() {
		return campoDddClienteAlt;
	}

	public void setCampoDddClienteAlt(HtmlInputText campoDddClienteAlt) {
		this.campoDddClienteAlt = campoDddClienteAlt;
	}

	public HtmlInputText getCampoTelefoneClienteAlt() {
		return campoTelefoneClienteAlt;
	}

	public void setCampoTelefoneClienteAlt(HtmlInputText campoTelefoneClienteAlt) {
		this.campoTelefoneClienteAlt = campoTelefoneClienteAlt;
	}

	public HtmlInputText getCampoTipoTelefoneAlt() {
		return campoTipoTelefoneAlt;
	}

	public void setCampoTipoTelefoneAlt(HtmlInputText campoTipoTelefoneAlt) {
		this.campoTipoTelefoneAlt = campoTipoTelefoneAlt;
	}

	public EnderecoClienteVO getEnderecoSelecionadoAlt() {
		return enderecoSelecionadoAlt;
	}

	public void setEnderecoSelecionadoAlt(EnderecoClienteVO enderecoSelecionadoAlt) {
		this.enderecoSelecionadoAlt = enderecoSelecionadoAlt;
	}

	public String getLogradouroClienteAlt() {
		return logradouroClienteAlt;
	}

	public void setLogradouroClienteAlt(String logradouroClienteAlt) {
		this.logradouroClienteAlt = logradouroClienteAlt;
	}

	public String getBairroClienteAlt() {
		return bairroClienteAlt;
	}

	public void setBairroClienteAlt(String bairroClienteAlt) {
		this.bairroClienteAlt = bairroClienteAlt;
	}

	public String getComplementoClienteAlt() {
		return complementoClienteAlt;
	}

	public void setComplementoClienteAlt(String complementoClienteAlt) {
		this.complementoClienteAlt = complementoClienteAlt;
	}

	public String getCepClienteAlt() {
		return cepClienteAlt;
	}

	public void setCepClienteAlt(String cepClienteAlt) {
		this.cepClienteAlt = cepClienteAlt;
	}

	public Double getCodEstadoAlt() {
		return codEstadoAlt;
	}

	public void setCodEstadoAlt(Double codEstadoAlt) {
		this.codEstadoAlt = codEstadoAlt;
	}

	public List<SelectItem> getListaEstadosAlt() {
		return listaEstadosAlt;
	}

	public void setListaEstadosAlt(List<SelectItem> listaEstadosAlt) {
		this.listaEstadosAlt = listaEstadosAlt;
	}

	public Double getCodCidadeAlt() {
		return codCidadeAlt;
	}

	public void setCodCidadeAlt(Double codCidadeAlt) {
		this.codCidadeAlt = codCidadeAlt;
	}

	public List<SelectItem> getListaCidadesAlt() {
		return listaCidadesAlt;
	}

	public void setListaCidadesAlt(List<SelectItem> listaCidadesAlt) {
		this.listaCidadesAlt = listaCidadesAlt;
	}

	public HtmlInputText getCampoLogradouroClienteAlt() {
		return campoLogradouroClienteAlt;
	}

	public void setCampoLogradouroClienteAlt(HtmlInputText campoLogradouroClienteAlt) {
		this.campoLogradouroClienteAlt = campoLogradouroClienteAlt;
	}

	public HtmlInputText getCampoBairroClienteAlt() {
		return campoBairroClienteAlt;
	}

	public void setCampoBairroClienteAlt(HtmlInputText campoBairroClienteAlt) {
		this.campoBairroClienteAlt = campoBairroClienteAlt;
	}

	public HtmlInputText getCampoComplementoClienteAlt() {
		return campoComplementoClienteAlt;
	}

	public void setCampoComplementoClienteAlt(
			HtmlInputText campoComplementoClienteAlt) {
		this.campoComplementoClienteAlt = campoComplementoClienteAlt;
	}

	public HtmlInputText getCampoCepClienteAlt() {
		return campoCepClienteAlt;
	}

	public void setCampoCepClienteAlt(HtmlInputText campoCepClienteAlt) {
		this.campoCepClienteAlt = campoCepClienteAlt;
	}

	public HtmlSelectOneMenu getCampoCidadeAlt() {
		return campoCidadeAlt;
	}

	public void setCampoCidadeAlt(HtmlSelectOneMenu campoCidadeAlt) {
		this.campoCidadeAlt = campoCidadeAlt;
	}

	public HtmlSelectOneMenu getCampoEstadoAlt() {
		return campoEstadoAlt;
	}

	public void setCampoEstadoAlt(HtmlSelectOneMenu campoEstadoAlt) {
		this.campoEstadoAlt = campoEstadoAlt;
	}

	public ClienteVO getClienteRecebidoEx() {
		return clienteRecebidoEx;
	}

	public void setClienteRecebidoEx(ClienteVO clienteRecebidoEx) {
		this.clienteRecebidoEx = clienteRecebidoEx;
	}

	public EnderecoClienteVO getEnderecoRecebidoEx() {
		return enderecoRecebidoEx;
	}

	public void setEnderecoRecebidoEx(EnderecoClienteVO enderecoRecebidoEx) {
		this.enderecoRecebidoEx = enderecoRecebidoEx;
	}

	public TelefoneClienteVO getTelefoneRecebidoEx() {
		return telefoneRecebidoEx;
	}

	public void setTelefoneRecebidoEx(TelefoneClienteVO telefoneRecebidoEx) {
		this.telefoneRecebidoEx = telefoneRecebidoEx;
	}

	public String getNomeClienteCon() {
		return nomeClienteCon;
	}

	public void setNomeClienteCon(String nomeClienteCon) {
		this.nomeClienteCon = nomeClienteCon;
	}

	public List<ClienteVO> getListaClientesCon() {
		return listaClientesCon;
	}

	public void setListaClientesCon(List<ClienteVO> listaClientesCon) {
		this.listaClientesCon = listaClientesCon;
	}

	public ClienteVO getClienteSelecionadoCon() {
		return clienteSelecionadoCon;
	}

	public void setClienteSelecionadoCon(ClienteVO clienteSelecionadoCon) {
		this.clienteSelecionadoCon = clienteSelecionadoCon;
	}

	public List<TelefoneClienteVO> getListaTelefonesCon() {
		return listaTelefonesCon;
	}

	public void setListaTelefonesCon(List<TelefoneClienteVO> listaTelefonesCon) {
		this.listaTelefonesCon = listaTelefonesCon;
	}

	public List<EnderecoClienteVO> getListaEnderecosCon() {
		return listaEnderecosCon;
	}

	public void setListaEnderecosCon(List<EnderecoClienteVO> listaEnderecosCon) {
		this.listaEnderecosCon = listaEnderecosCon;
	}

	public List<EnderecoClienteVO> getListaEnderecoAuxInc() {
		return listaEnderecoAuxInc;
	}

	public void setListaEnderecoAuxInc(List<EnderecoClienteVO> listaEnderecoAuxInc) {
		this.listaEnderecoAuxInc = listaEnderecoAuxInc;
	}

	public List<EnderecoClienteVO> getListaEnderecoAuxEx() {
		return listaEnderecoAuxEx;
	}

	public void setListaEnderecoAuxEx(List<EnderecoClienteVO> listaEnderecoAuxEx) {
		this.listaEnderecoAuxEx = listaEnderecoAuxEx;
	}

	public List<EnderecoClienteVO> getListaDialogEndereco() {
		return listaDialogEndereco;
	}

	public void setListaDialogEndereco(List<EnderecoClienteVO> listaDialogEndereco) {
		this.listaDialogEndereco = listaDialogEndereco;
	}

	public String getLogradouroClienteAux() {
		return logradouroClienteAux;
	}

	public void setLogradouroClienteAux(String logradouroClienteAux) {
		this.logradouroClienteAux = logradouroClienteAux;
	}

	public String getBairroClienteAux() {
		return bairroClienteAux;
	}

	public void setBairroClienteAux(String bairroClienteAux) {
		this.bairroClienteAux = bairroClienteAux;
	}

	public String getComplementoClienteAux() {
		return complementoClienteAux;
	}

	public void setComplementoClienteAux(String complementoClienteAux) {
		this.complementoClienteAux = complementoClienteAux;
	}

	public String getCepClienteAux() {
		return cepClienteAux;
	}

	public void setCepClienteAux(String cepClienteAux) {
		this.cepClienteAux = cepClienteAux;
	}

	public Double getCodEstadoAux() {
		return codEstadoAux;
	}

	public void setCodEstadoAux(Double codEstadoAux) {
		this.codEstadoAux = codEstadoAux;
	}

	public List<SelectItem> getListaEstadosAux() {
		return listaEstadosAux;
	}

	public void setListaEstadosAux(List<SelectItem> listaEstadosAux) {
		this.listaEstadosAux = listaEstadosAux;
	}

	public Double getCodCidadeAux() {
		return codCidadeAux;
	}

	public void setCodCidadeAux(Double codCidadeAux) {
		this.codCidadeAux = codCidadeAux;
	}

	public List<SelectItem> getListaCidadesAux() {
		return listaCidadesAux;
	}

	public void setListaCidadesAux(List<SelectItem> listaCidadesAux) {
		this.listaCidadesAux = listaCidadesAux;
	}

	public HtmlSelectOneMenu getCampoCidadeAux() {
		return campoCidadeAux;
	}

	public void setCampoCidadeAux(HtmlSelectOneMenu campoCidadeAux) {
		this.campoCidadeAux = campoCidadeAux;
	}

	public List<TelefoneClienteVO> getListaTelefoneAuxInc() {
		return listaTelefoneAuxInc;
	}

	public void setListaTelefoneAuxInc(List<TelefoneClienteVO> listaTelefoneAuxInc) {
		this.listaTelefoneAuxInc = listaTelefoneAuxInc;
	}

	public List<TelefoneClienteVO> getListaTelefoneAuxEx() {
		return listaTelefoneAuxEx;
	}

	public void setListaTelefoneAuxEx(List<TelefoneClienteVO> listaTelefoneAuxEx) {
		this.listaTelefoneAuxEx = listaTelefoneAuxEx;
	}

	public List<TelefoneClienteVO> getListaDialogTelefone() {
		return listaDialogTelefone;
	}

	public void setListaDialogTelefone(List<TelefoneClienteVO> listaDialogTelefone) {
		this.listaDialogTelefone = listaDialogTelefone;
	}

	public String getDddClienteAux() {
		return dddClienteAux;
	}

	public void setDddClienteAux(String dddClienteAux) {
		this.dddClienteAux = dddClienteAux;
	}

	public String getTelefoneClienteAux() {
		return telefoneClienteAux;
	}

	public void setTelefoneClienteAux(String telefoneClienteAux) {
		this.telefoneClienteAux = telefoneClienteAux;
	}

	public String getTipoTelefoneAux() {
		return tipoTelefoneAux;
	}

	public void setTipoTelefoneAux(String tipoTelefoneAux) {
		this.tipoTelefoneAux = tipoTelefoneAux;
	}

	public Double getIdClienteAlt() {
		return idClienteAlt;
	}

	public void setIdClienteAlt(Double idClienteAlt) {
		this.idClienteAlt = idClienteAlt;
	}

	public ClienteBO getBo() {
		return bo;
	}

	public void setBo(ClienteBO bo) {
		this.bo = bo;
	}
	
	

}
