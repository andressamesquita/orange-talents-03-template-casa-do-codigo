package br.com.zupacademy.andressa.casadocodigo.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValorUnicoValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {

	String message() default "Este dado já está cadastrado";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    String value() default "";
    
    String fieldName();
    Class<?> domainClass();
}