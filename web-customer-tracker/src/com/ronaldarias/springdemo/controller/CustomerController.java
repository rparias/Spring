package com.ronaldarias.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/mostrarFormForAdd")
	public String mostrarFormForAdd(Model theModel) {
		
		//crear atributo de modelo para pasar los datos
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/guardarCustomer")
	public String guardarCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//guardar el Customer con la ayuda del service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/mostrarFormForUpdate")
	public String mostrarFormForUpdate(@RequestParam("customerId") int theID, Model theModel) {
		
		//obtener el customer de la DB
		Customer theCustomer = customerService.getCustomer(theID);
		
		//poner el customer como los atributos del modelo para llenar el formulario
		theModel.addAttribute("customer", theCustomer);
		
		//enviarlos al formulario
		return "customer-form";
	}
}
