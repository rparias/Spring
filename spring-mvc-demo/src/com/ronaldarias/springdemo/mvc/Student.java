package com.ronaldarias.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	
	//LinkedHashMap itera en el orden que se ingresan las cosas al mapa
	private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		//populate country options: used ISO country code
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brasil");
		countryOptions.put("AR", "Argentina");
		countryOptions.put("EC", "Ecuador");
		countryOptions.put("CO", "Colombia");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
}
