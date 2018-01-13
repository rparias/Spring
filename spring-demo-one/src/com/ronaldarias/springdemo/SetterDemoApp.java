package com.ronaldarias.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		// Paso 2: Crear un contenedor Spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Paso 3: Recuperar los beans del contenedor Spring
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

		// llamar a los metodos del bean
		System.out.println(theCoach.getDailyWorkOut());

		// llamar al metodo de la fortuna
		System.out.println(theCoach.getDailyFortune());

		// cerar el context
		context.close();

	}

}
