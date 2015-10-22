package br.lecom.web.constraint.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.lecom.web.constraint.service.Cpf;

/**
 * Essa classe representa a implementa��o da valida��o do Bean Validator.
 * Essa classe obrigatoriamente deve implementar a interface ConstraintValidator e ter� como generic type dois tipo:
 * 1 - O tipo da Annotation da valida��o
 * 2 - O tipo do dado que ser� validado
 * @author fernando.palharin
 *
 */
public class CpfImpl implements ConstraintValidator<Cpf, String>{
	
	private String mensagem;
	
	@Override
	public void initialize(Cpf anotacao) {
		this.mensagem = anotacao.message();
		
	}
	
	@Override
	public boolean isValid(String valor, ConstraintValidatorContext context) {
		
			if(!valor.matches("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}")){
				return false;
			}
			
		
		
		return true;
	}


}
