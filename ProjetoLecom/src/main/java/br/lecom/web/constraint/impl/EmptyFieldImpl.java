package br.lecom.web.constraint.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.lecom.web.constraint.service.EmptyField;
import br.lecom.web.util.UtilFuncoes;

/**
 * Essa classe representa a implementação da validação do Bean Validator.
 * Essa classe obrigatoriamente deve implementar a interface ConstraintValidator e terá como generic type dois tipo:
 * 1 - O tipo da Annotation da validação
 * 2 - O tipo do dado que será validado
 * @author fernando.palharin
 *
 */
public class EmptyFieldImpl implements ConstraintValidator<EmptyField, Object>{
	
	private String mensagem;

	
	@Override
	public void initialize(EmptyField anotacao) {
		
		this.mensagem = anotacao.message();
		
		
		
	}

	@Override
	public boolean isValid(Object valor, ConstraintValidatorContext contexto) {
		
	
		
		if(valor == null){
			
			
			
			return false;
		}
		
		if(valor instanceof String){
			
			String campo = (String) valor;
			
			if(UtilFuncoes.isCampoVazio(campo)){
				
				
				
				return false;
			}
			
		}
		
		if(valor instanceof ArrayList){
			
			List lista = (List) valor;
			
			if(lista.size() == 0){
				return false;
			}
		}
		
		return true;
	}

}
