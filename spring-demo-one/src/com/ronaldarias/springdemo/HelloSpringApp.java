package com.ronaldarias.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//Paso 2: Crear un contenedor Spring
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Paso 3: Recuperar los beans del contenedor Spring
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//llamar a los metodos del bean
		System.out.println(theCoach.getDailyWorkOut());
		
		//cerar el context
		context.close();

	}

}
