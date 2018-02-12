package com.ronaldarias.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		//Leer el archivo de configuracion Spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//Obtener el bean del contenedor
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach footballCoach = context.getBean("footballCoach", Coach.class);
		
		
		//Llamar al metodo del bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(footballCoach.getDailyWorkout());
		
		//Llamar al metodo para obtener la fortuna
		System.out.println(theCoach.getDailyFortune());
		System.out.println(footballCoach.getDailyFortune());
		
		
		//Cerrar el contexto
		context.close();

	}

}
