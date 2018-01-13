package com.ronaldarias.springdemo;

public class BaseballCoach implements Coach  {
	
	//definir un atributo para la dependencia
	private FortuneService fortuneService;
	
	//definir un constructor para la inyeccion de dependencia
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
		return "Se invirtieron 30 minutos en la práctica de bateo";
	}

	@Override
	public String getDailyFortune() {
		//uso mi fortuneService para tener fortuna
		return fortuneService.getFortune();
	}

	@Override
	public String getSuerte() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
