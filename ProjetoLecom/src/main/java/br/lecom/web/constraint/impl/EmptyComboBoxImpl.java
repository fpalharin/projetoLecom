package br.lecom.web.constraint.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.lecom.web.constraint.service.EmptyComboBox;

/**
 * Essa classe representa a implementação da validação do Bean Validator.
 * Essa classe obrigatoriamente deve implementar a interface ConstraintValidator e terá como generic type dois tipo:
 * 1 - O tipo da Annotation da validação
 * 2 - O tipo do dado que será validado
 * @author fernando.palharin
 *
 */
public class EmptyComboBoxImpl implements ConstraintValidator<EmptyComboBox, Object>{
	
	private String mensagem;

	@Override
	public void initialize(EmptyComboBox anotacao) {
		
		this.mensagem = anotacao.message();
		
	}

	@Override
	public boolean isValid(Object valor, ConstraintValidatorContext context) {
		
		if(valor instanceof String){
			
			String valorTexto = (String) valor;
			
			if(valorTexto.trim().equals("0")){
				return false;
			}
		}
		
		if(valor instanceof Integer){
			Integer valorNumerico = (Integer) valor;
			
			if(valorNumerico.equals(0)){
				return false;
			}
		}
		
		if(valor instanceof Long){
			Long valorNumerico = (Long) valor;
			
			if(valorNumerico.equals(0l)){
				return false;
			}
		}
		
		if(valor instanceof Double){
			Double valorNumerico = (Double) valor;
			
			if(valorNumerico.equals(0d)){
				return false;
			}
		}
		
		return true;
	}

}
