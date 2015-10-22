package br.lecom.web.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import br.lecom.web.util.UtilFuncoes;

public class LogFactory {
	
	@Produces
	public Logger getLogger(InjectionPoint ponto){
		
		Logger log = Logger.getLogger(ponto.getMember().getDeclaringClass().getName());
		
		
		try {
			
			log.addHandler(new FileHandler(UtilFuncoes.PATH_LOG, true));
			
		} catch (SecurityException e) {
			
			log.severe(e.getMessage());
			
		} catch (IOException e) {
			
			log.severe(e.getMessage());
			
		}
		
		return log;
	}

}
