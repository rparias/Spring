package com.ronaldarias.springdemo.mvc;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class Customer {
	private String firstName;
	
	@NotNull(message="campo requerido")
	@Size(min=1, message="campo requerido")
	private String lastName;


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
}
