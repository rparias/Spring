package com.ronaldarias.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ronaldarias.springdemo.entity.Customer;
import com.ronaldarias.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//necesito inyectar el customerService
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//obtener los customers desde el servicio creado
		List<Customer> theCustomers = customerService.getCustomers();
		
		//agergar los customers al modelo
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
}
