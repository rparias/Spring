package com.ronaldarias.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidatior 
	implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	
	//aqui va la logica que determina si es valido o no
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result;
		
		if(theCode != null)
			result = theCode.startsWith(coursePrefix);
		else
			result = true;
		
		return result;
	}

}
