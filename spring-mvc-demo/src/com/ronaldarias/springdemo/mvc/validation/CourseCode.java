package com.ronaldarias.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidatior.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	//definir el course code por defecto
	public String value() default "RON";
	
	//definir el mensaje de error por defecto
	public String message() default "debe empezar con RON";
	
	//definir los default groups
	public Class<?>[] groups() default {};
	
	//definir los default payloads
	public Class<? extends Payload>[] payload() default {};
	
}
