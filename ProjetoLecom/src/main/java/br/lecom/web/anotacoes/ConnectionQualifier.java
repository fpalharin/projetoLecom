package br.lecom.web.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import br.lecom.web.enumeradores.TipoConexao;

@Qualifier
@Target(value={ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConnectionQualifier {
	
	TipoConexao tipoConexao() default TipoConexao.ORACLE;


}
