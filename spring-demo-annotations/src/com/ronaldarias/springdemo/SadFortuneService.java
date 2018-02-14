package com.ronaldarias.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Te ira mal nadando";
	}

}
