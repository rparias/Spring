package com.ronaldarias.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService; 
	
	public CricketCoach() {
		System.out.println("CricketCoach: constructor sin parametros");
	}

	@Override
	public String getDailyWorkOut() {
		return "Practica de bowling por 15 minutos";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	//metodo set
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: dentro del metodo setter");
		this.fortuneService = fortuneService;
	}

}
