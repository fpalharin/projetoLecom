package br.lecom.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.enterprise.inject.Produces;

import br.lecom.web.anotacoes.ConnectionQualifier;
import br.lecom.web.enumeradores.TipoConexao;

public class ConnectionFactory {
	
	@Produces
	@ConnectionQualifier(tipoConexao = TipoConexao.ORACLE)
	public Connection getConexaoOracle(){
		
		Connection conexao = null;
		
		try {
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","fernando","maker123");
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return conexao;
		
	}
}
