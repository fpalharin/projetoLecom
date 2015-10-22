package br.lecom.web.constraint.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.lecom.web.constraint.impl.RgImpl;


@Constraint(validatedBy = RgImpl.class)
@Documented
@Target(value=ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Rg {
	
		//Só utilizamos o primeiro método, para retornar a mensagem de erro
		String message() default "Formato Invalido";
		
		Class<?>[] groups() default {};
		
		Class<? extends Payload>[] payload() default {};
}
