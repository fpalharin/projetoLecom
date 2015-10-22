package br.lecom.web.constraint.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.lecom.web.constraint.service.Cep;

/**
 * Essa classe representa a implementação da validação do Bean Validator.
 * Essa classe obrigatoriamente deve implementar a interface ConstraintValidator e terá como generic type dois tipo:
 * 1 - O tipo da Annotation da validação
 * 2 - O tipo do dado que será validado
 * @author fernando.palharin
 *
 */
public class CepImpl implements ConstraintValidator<Cep, String>{
	
	private String mensagem;
	
	@Override
	public void initialize(Cep anotacao) {
		this.mensagem = anotacao.message();
	}

	@Override
	public boolean isValid(String valor, ConstraintValidatorContext context) {
		
		if(!valor.matches("[0-9]{2}\\.?[0-9]{3}\\-?[0-9]{3}")){
			
			return false;
		}
		
		return true;
	}


}
