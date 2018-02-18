package com.ronaldarias.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	//nuevo metodo controlador para leer los datos desde HTML y agregarlos al modelo
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		
		String result = "Yo! " + theName.toUpperCase();
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
