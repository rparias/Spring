package com.ronaldarias.springdemo;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data = {"Buena suerte!", "Hoy ganaran!", "Será un gran día"};
	
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		
		int index = myRandom.nextInt(data.length);
		return data[index];
	}

}
