package com.ronaldarias.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		//Leer la clase de configuracion Spring
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		//Obtener el bean del contenedor
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		
		//Llamar al metodo del bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Llamar al metodo para obtener la fortuna
		System.out.println(theCoach.getDailyFortune());
		
		
		//Cerrar el contexto
		context.close();

	}

}
