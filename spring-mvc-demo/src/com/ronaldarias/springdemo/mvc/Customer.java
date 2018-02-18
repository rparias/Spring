package com.ronaldarias.springdemo.mvc;

import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Customer {
	private String firstName;
	
	@NotNull(message="campo requerido")
	@Size(min=1, message="campo requerido")
	private String lastName;
	
	@NotNull(message="campo requerido")
	@Min(value=0, message="Debe ser un valor mayor o igual a cero")
	@Max(value=10, message="Debe ser un valor menor o igual a 10")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="Solo hasta 5 caracteres o digitos")
	private String postalCode;


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


	public Integer getFreePasses() {
		return freePasses;
	}


	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
