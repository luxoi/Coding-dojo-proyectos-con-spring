package com.codingdojo.luis.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controladores {
	
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@GetMapping("/result")
	public String Result() {
		return "result.jsp";
	}
	
	@PostMapping("/datos")
	public String datos(@RequestParam(value="nombre") String name, 
	                    @RequestParam(value="location") String location,
	                    @RequestParam(value="favorite") String favorite,
	                    @RequestParam(value="comentario") String comentario,                            
	                    Model model) {
	    model.addAttribute("nombre", name);
	    model.addAttribute("location", location);
	    model.addAttribute("favorite", favorite);
	    model.addAttribute("comentario", comentario);
	    return "result.jsp";
	}
	@PostMapping("/")
	public String boton(@RequestParam(value="nombree") String name, Model model) {
		return "index.jsp";
	}
}
