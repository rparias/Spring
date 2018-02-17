package com.ronaldarias.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	//metodo para mostrar la pagina inicial HTML
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	//metodo para procesar el formulario HTML
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
}
