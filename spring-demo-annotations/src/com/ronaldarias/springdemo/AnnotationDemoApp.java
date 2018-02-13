package com.ronaldarias.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		//Leer el archivo de configuracion Spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//Obtener el bean del contenedor
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		
		//Llamar al metodo del bean
		System.out.println(theCoach.getDailyWorkout());
		
		//Llamar al metodo para obtener la fortuna
		System.out.println(theCoach.getDailyFortune());
		
		
		//Cerrar el contexto
		context.close();

	}

}
