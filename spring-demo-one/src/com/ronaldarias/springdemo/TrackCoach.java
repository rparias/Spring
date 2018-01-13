package com.ronaldarias.springdemo;

public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkOut() {
		return "Corre duro 5Km";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
