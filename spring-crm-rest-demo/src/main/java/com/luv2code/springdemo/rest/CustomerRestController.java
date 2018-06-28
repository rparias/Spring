package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// injection dependency
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer customer = customerService.getCustomer(customerId);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}
		
		return customer;
	}
	
	
	// add mapping for POST /customers - add new customer
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		customer.setId(0);
		
		customerService.saveCustomer(customer);
		
		return customer;
		
	}
}
