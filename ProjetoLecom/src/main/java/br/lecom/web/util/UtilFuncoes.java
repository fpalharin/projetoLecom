package br.lecom.web.util;

public class UtilFuncoes {
	
	public static final String PATH_LOG = "C:/Desenvolvimento/logs/log.txt";
	
	public static final String FLAG_COMBO = "0";
	
	public static final String PARAM_ENTRADA = "action";
	
	public static final String PATH_RETORNO = "/jsf-pages/paginas/cliente/consultarCliente?faces-redirect=true&action=Consultar_Alterar";
	
	public static boolean isCampoComboValido(String campoCombo){
		
		return campoCombo == null || campoCombo.trim().equalsIgnoreCase(FLAG_COMBO);
	}
	
	public static boolean isCampoVazio(String campo){
		
		return campo == null || campo.trim().equals("");
	}

	public static boolean validarTamanhoMaximoEmail(String email){
		
		return email.length() <= 150;
	}
	
	public static boolean validarTamanhoMaximoTelefone(String telefone){
		
		return telefone.length() <= 9;
	}
	
	public static boolean validarTamanhoMaximoDDD(String ddd){
		
		return ddd.length() <= 2;
	}
}
