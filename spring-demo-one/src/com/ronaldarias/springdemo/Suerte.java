package com.ronaldarias.springdemo;

import java.util.Random;

public class Suerte implements FortuneService {
	
	private String[] fortuneArray = {"Que tengas suertecita", "Que te vaya bonito", "Suerte!"};
	private int randomNum;
	private Random rand = new Random();

	@Override
	public String getFortune() {
		return fortuneArray[generarNumero()];
	}
	
	public int generarNumero() {
		randomNum = rand.nextInt((2 - 0) + 1) + 0;
		return randomNum;
	}

}
