package com.ronaldarias.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		//uso la interfaz
		Coach theCoach = new TrackCoach();
		
		System.out.println(theCoach.getDailyWorkOut());

	}

}
