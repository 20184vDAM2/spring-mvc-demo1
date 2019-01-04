package com.sge.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
		
	// need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
		
	//añadir datos al modelo (2). Importar el modelo de spring y HttpServletRequest
	// new a controller method to read form data and add data to the model

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");

		// convertir a mayúsculas
		theName = theName.toUpperCase();

		// crear el mensaje
		String result = "Yo! " + theName;

		// añadir mensaje al modelo
		model.addAttribute("message", result); //(nombre,valor)

		return "helloworld";
	}

	
	@RequestMapping("/processFormVersionThree")	
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, 
			Model model) {
				
		// convertir a mayúsculas. Fijarse bien que ahora no hace falta
		//String theName = request.getParameter("studentName");
		theName = theName.toUpperCase();
		
		// crear el mensaje
		String result = "Hola colega! " + theName;
		
		// añadir mensaje al modelo
		model.addAttribute("message", result);
				
		return "helloworld";
	}	
}
