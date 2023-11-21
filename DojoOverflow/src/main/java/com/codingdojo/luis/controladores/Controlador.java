package com.codingdojo.luis.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.luis.modelos.Etiqueta;
import com.codingdojo.luis.modelos.Pregunta;
import com.codingdojo.luis.modelos.Respuesta;
import com.codingdojo.luis.servicios.Servicios;

import jakarta.validation.Valid;

@Controller
public class Controlador {
	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/")
	public String inicio() {
		return "redirect:/preguntas";
	}
	
	@GetMapping("/preguntas")
	public String preguntas(Model model) {
		List<Pregunta> preguntas= servicio.todasPreguntas();
		model.addAttribute("preguntas", preguntas);
		
		return "index.jsp";
	}
	@GetMapping("/nueva")
	public String nueva(@ModelAttribute("pregunta")Pregunta pregunta) {
		
		return "nueva.jsp";
	}
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("pregunta")Pregunta pregunta,
						BindingResult result,
						@RequestParam("textoEtiquetas")String textoEtiquetas) {
		if(result.hasErrors()){
			return "nueva.jsp";
		} else {
			String[] listaEtiquetas = textoEtiquetas.trim().split(",");
			List<Etiqueta> etiquetas = new ArrayList<>();
			
			for(String tema:listaEtiquetas) {
				tema= tema.trim();
				Etiqueta eti = servicio.encuentraEtiqueta(tema);
				
				if( eti == null) {
					Etiqueta nuevaEtiqueta = new Etiqueta();
					nuevaEtiqueta.setTema(tema);
					servicio.guardarEtiqueta(nuevaEtiqueta);
					etiquetas.add(nuevaEtiqueta);
				}else {
					etiquetas.add(eti);
				}
			}
			pregunta.setEtiquetas(etiquetas);
			servicio.guardarPreguntas(pregunta);
			return "redirect:/preguntas";
		}
	}
	
	@GetMapping("/preguntas/{id}")
	public String pregunta(@PathVariable("id")Long id, Model model,
							@ModelAttribute("respuesta")Respuesta respuesta) {
		
		Pregunta pregunta = servicio.encuentraPregunta(id);
		model.addAttribute("pregunta", pregunta);
		return "pregunta.jsp";
	}
	@PostMapping("/respuesta")
	public String respuesta(@Valid @ModelAttribute("respuesta")Respuesta respuesta,
							BindingResult result) {
		if(result.hasErrors()) {
			return "preguntas.jsp";
		}else {
			servicio.guardarRespuesta(respuesta);
			return "redirect:/preguntas/"+respuesta.getPregunta().getId();
		}
	}
	
}
