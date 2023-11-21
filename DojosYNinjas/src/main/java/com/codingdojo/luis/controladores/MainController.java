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
import org.springframework.web.bind.annotation.RequestMapping;
import com.codingdojo.luis.modelos.Dojo;
import com.codingdojo.luis.modelos.Ninja;
import com.codingdojo.luis.servicios.Servicio;

import jakarta.validation.Valid;

@Controller
@RequestMapping
public class MainController {
	@Autowired
	private Servicio service;
	
	
	@GetMapping("/")
	private String index(Model model) {
		List<Dojo> listaDeDojos = service.findDojo();
		model.addAttribute("dojos", listaDeDojos);
		return "index.jsp";
	}
	
	@GetMapping("/dojo/new")
	private String newDojo(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "newdojo.jsp";
	}
	
	@PostMapping("/crear")
		public String crearDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		service.guardarDojo(dojo);
		return "redirect:/";
	}
	
	@GetMapping("/ninja/new")
	private String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = service.findDojo();

		model.addAttribute("dojos", dojos);
		return "newninja.jsp";
	}
	
	@PostMapping("/nuevo")
	public String crearNinja(@Valid @ModelAttribute("ninja")Ninja ninja,BindingResult result) {
		service.guardarNinja(ninja);
		return "redirect:/";
	}
	@GetMapping("/dojos/{id}")
	public String dojos(@PathVariable("id")Long id, Model model) {
		Dojo dojo = service.findDojos(id);
		model.addAttribute("dojo", dojo);
		return "dojos.jsp";
	}
	
	
	
}
