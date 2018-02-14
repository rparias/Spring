package com.ronaldarias.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	//con Qualifier llamo especificamente a HappyFortuneService para la inyeccion
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> TennisCoach: Entro al constructor por defecto");
	}

	//init-method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: dentro de doMyStartupStuff");
	}
	
	//destroy-method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: dentro de doMyCleanupStuff");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
