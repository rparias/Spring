package com.ronaldarias.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//atributos para setters personalizados
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.println("CricketCoach: constructor sin parametros");
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
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

	@Override
	public String getSuerte() {
		return fortuneService.getFortune();
	}

}
