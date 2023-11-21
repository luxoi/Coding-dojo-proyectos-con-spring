package com.codingdojo.luis.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.luis.modelos.Chiste;
import com.codingdojo.luis.servicios.Servicios;

@Controller
public class Controlador {

	@Autowired
	private Servicios servicio;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Chiste> ListaChistes = servicio.muestraChistes("blanco");
		
		model.addAttribute("chistes", ListaChistes);
		return "index.jsp";
		
	}
}
