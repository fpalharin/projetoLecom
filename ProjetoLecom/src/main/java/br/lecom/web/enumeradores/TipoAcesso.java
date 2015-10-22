package br.lecom.web.enumeradores;

public enum TipoAcesso {
	
	INCLUIR("Incluir"),ALTERAR("Alterar"),CONSULTAR("Consultar"),CONSULTAR_ALTERAR("Consultar_Alterar"),ALTERAR_TELEFONE("Alterar_Telefone"),ALTERAR_ENDERECO("Alterar_Endereco");
	
	
	private String acesso;
	
	
	private TipoAcesso(){
		
	}
	
	private TipoAcesso(String acesso){
		this.acesso = acesso;
	}
	
	public String getAcesso(){
		return this.acesso;
	}

}
