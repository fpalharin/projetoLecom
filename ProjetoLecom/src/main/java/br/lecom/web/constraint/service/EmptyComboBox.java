package br.lecom.web.constraint.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.lecom.web.constraint.impl.EmptyComboBoxImpl;



@Constraint(validatedBy=EmptyComboBoxImpl.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.FIELD)
public @interface EmptyComboBox {
	
	//S� utilizamos o primeiro m�todo, para retornar a mensagem de erro
	String message() default "O campo � obrigat�rio";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
