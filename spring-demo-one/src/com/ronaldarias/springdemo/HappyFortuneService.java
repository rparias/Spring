package com.ronaldarias.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Hoy es tu día de suerte!";
	}

}
