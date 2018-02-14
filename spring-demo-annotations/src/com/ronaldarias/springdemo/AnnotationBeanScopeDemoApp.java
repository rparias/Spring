package com.ronaldarias.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		//cargar el archivo de confiruacion de spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//recuperar los beans del contenedor
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nApuntando al mismo objeto: " + result);
		
		System.out.println("\nLocacion de memoria de theCoach: " + theCoach);
		System.out.println("\nLocacion de memoria de alphaCoach: " + alphaCoach);
		
		//cerrar el context
		context.close();
	}

}
