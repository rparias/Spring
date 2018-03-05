package com.ronaldarias.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ronaldarias.springdemo.dao.CustomerDAO;
import com.ronaldarias.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//necesito inyectar el customerDAO
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//obtener los customers desde el dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//agergar los customers al modelo
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
}
