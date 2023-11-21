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
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.luis.modelos.Proyecto;
import com.codingdojo.luis.modelos.Usuario;
import com.codingdojo.luis.servicios.ServicioProyectos;
import com.codingdojo.luis.servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class ControladorProyectos {
	@Autowired
	private Servicios servicio;
	
	@Autowired
	private ServicioProyectos sp;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session,
							Model model)  {
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
			if(usuarioTemporal == null) {
				return "redirect:/";
			}
				
		model.addAttribute("misProyectos", sp.encuentraMisProyectos(usuarioTemporal));		
			
		model.addAttribute("otrosProyectos", sp.encontrarOtrosProyectos(usuarioTemporal));	
		
		
		return "dashboard.jsp";
	}
	@GetMapping("/nuevo")
	public String nuevo(HttpSession session,
						@ModelAttribute("proyecto")Proyecto proyecto) {
		
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		return "nuevo.jsp";
		
	}
	@PostMapping("/crear")
	public String crear(HttpSession session,
						@Valid @ModelAttribute("proyecto")Proyecto proyecto,
						BindingResult result) {
		
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "nuevo.jsp";
		}else {
			 sp.guardarProyecto(proyecto);
			 
			 Usuario miUsuario = sp.encontrarUsuario(usuarioTemporal.getId());
			 miUsuario.getProyectosUnidos().add(proyecto);
			 sp.guardarUsuario(miUsuario);
			 return ("redirect:/dashboard");
		}
		
	}
	@GetMapping("/editar/{id}")
	public String editar(HttpSession session,
						@PathVariable("id")Long id,
						@ModelAttribute("proyecto")Proyecto proyecto,
						Model model) {
		
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		Proyecto proyectoEditar = sp.encontrarProyecto(id);
		
		if(usuarioTemporal.getId() != proyectoEditar.getLider().getId()) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("proyecto", proyectoEditar);
		return "editar.jsp";
	}
	@PutMapping("/actualizar")
	public String update(HttpSession session,
						@Valid @ModelAttribute("proyecto")Proyecto proyecto,
						BindingResult result) {
		

		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "editar.jsp";
		}else {
			Proyecto esteProyecto = sp.encontrarProyecto(proyecto.getId());
			List<Usuario> usuariosUnidosAlProyecto = esteProyecto.getUsuariosUnidos();
			proyecto.setUsuariosUnidos(usuariosUnidosAlProyecto);
			
			sp.guardarProyecto(proyecto);
			return "redirect:/dashboard";
			
		}
	}
	@GetMapping("/unir/{proyectoId}")
	public String unir(HttpSession session, 
						@PathVariable("proyectoId") Long proyectoId){
		
		
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		sp.unirProyecto(usuarioTemporal.getId(), proyectoId);
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/salir/{proyectoId}")
	public String salir(HttpSession session,
						@PathVariable("proyectoId")Long proyectoId) {
		
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		sp.salirProyecto(usuarioTemporal.getId(), proyectoId);
		return "redirect:/dashboard";
	}
							
	
}
