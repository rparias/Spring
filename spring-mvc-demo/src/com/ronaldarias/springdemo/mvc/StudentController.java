package com.ronaldarias.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		//crear objeto Student
		Student theStudent = new Student();
		
		//agregar objeto Student al modelo
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + 
				theStudent.getLastName() + " Pais: " + theStudent.getCountry());
		
		return "student-confirmation";
	}
}
