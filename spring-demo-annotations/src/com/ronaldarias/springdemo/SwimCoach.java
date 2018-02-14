package com.ronaldarias.springdemo;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Nado de 1000 metros";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
