package com.codingdojo.luis.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.codingdojo.luis.models.License;
import com.codingdojo.luis.models.Person;
import com.codingdojo.luis.servicios.ProjectService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private ProjectService service;
	
	@GetMapping("/")
	public String index(@ModelAttribute("person")Person person) {
		return "index.jsp";
	}
	@PostMapping("/person/create")
	public String savePerson(@Valid @ModelAttribute("person")Person person,
							BindingResult result) {
			if(result.hasErrors()) {
				return "index.jsp";
			}
			service.savePerson(person);
			return "redirect:/";
	}
	@GetMapping("/new")
	public String newLicense(@ModelAttribute("license")License license,
			Model model) {
		List<Person> encontrar= service.findpeople();
		model.addAttribute("people", encontrar);
		return "new.jsp";
	}
	@PostMapping("/license/create")
	public String saveLicense(@Valid @ModelAttribute("license")License license,
							BindingResult result, Model model) {
			if(result.hasErrors()) {
				List<Person> encontrar= service.findpeople();
				model.addAttribute("people", encontrar);
				return "new.jsp";
			}
			service.saveLicense(license);
			return "redirect:/new";
	} 
	@GetMapping("/persons/{id}")
	public String Persons(@PathVariable("id") Long id, 
						  Model model) {
		Person persona = service.findPerson(id);
		model.addAttribute("person", persona);
		return "persons.jsp";
	}
}
