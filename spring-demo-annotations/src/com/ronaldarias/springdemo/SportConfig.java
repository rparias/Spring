package com.ronaldarias.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.ronaldarias.springdemo")
public class SportConfig {
	
	//definir bean para la mala suerte
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//definir bean para el SwimCoach y la inyeccion de dependencia
	@Bean
	public Coach swimCoach(FortuneService fortuneService) {
		return new SwimCoach(sadFortuneService());
	}
	
}

