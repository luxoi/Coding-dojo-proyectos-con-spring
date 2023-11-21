package com.codingdojo.luis.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.luis.Modelos.Estado;
import com.codingdojo.luis.Modelos.Evento;
import com.codingdojo.luis.Modelos.Mensaje;
import com.codingdojo.luis.Modelos.Usuario;
import com.codingdojo.luis.Servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorEventos {
	@Autowired
    private Servicios servicio;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session,
    						Model model,
    						@ModelAttribute("nuevoEvento") Evento nuevoEvento) {
    
        Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
        if(usuarioTemporal == null) {
            return "redirect:/";
        }
        
        String miEstado = usuarioTemporal.getEstado();
        
        List<Evento> eventosMiEstado = servicio.eventosEnMiEstado(miEstado);
        model.addAttribute("eventosMiEstado", eventosMiEstado);
        
        List<Evento> eventosOtroEstado = servicio.eventosOtrosEstados(miEstado);
        model.addAttribute("eventosOtroEstado", eventosOtroEstado);
        
        Usuario miUsuario = servicio.encontrarUsuario(usuarioTemporal.getId());
        model.addAttribute("usuario", miUsuario);
        
        model.addAttribute("estados", Estado.Estados);
        
        return "dashboard.jsp";
    }
    @PostMapping("/crear")
    public String crear(HttpSession session,
    					@Valid @ModelAttribute("nuevoEvento")Evento nuevoEvento,
    					BindingResult result,
    					Model model) {
        Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
        if(usuarioTemporal == null) {
            return "redirect:/";
         }
        if(result.hasErrors()) {
        	 String miEstado = usuarioTemporal.getEstado();
             
             List<Evento> eventosMiEstado = servicio.eventosEnMiEstado(miEstado);
             model.addAttribute("eventosMiEstado", eventosMiEstado);
             
             List<Evento> eventosOtroEstado = servicio.eventosOtrosEstados(miEstado);
             model.addAttribute("eventosOtroEstado", eventosOtroEstado);
             
             Usuario miUsuario = servicio.encontrarUsuario(usuarioTemporal.getId());
             model.addAttribute("usuario", miUsuario);
            model.addAttribute("estados", Estado.Estados);
            return("dashboard.jsp");
        } else {
        	servicio.GuardarEvento(nuevoEvento);
        	return "redirect:/dashboard";
        }
    }
    @GetMapping("/unir/{id}")
    public String unir(@PathVariable("id")Long eventoId,
    				   HttpSession session) {
    	  Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
          if(usuarioTemporal == null) {
              return "redirect:/";
          }
          servicio.unirEvento(usuarioTemporal.getId(), eventoId);
          return "redirect:/dashboard";
    }
    @GetMapping("/quitar/{id}")
    public String quitar(@PathVariable("id")Long eventoId,
    					HttpSession session) {
    	 Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
         if(usuarioTemporal == null) {
             return "redirect:/";
         }
         servicio.quitarEvento(usuarioTemporal.getId(), eventoId);
         return "redirect:/dashboard";
    }
    @GetMapping("/evento/{id}")
    public String evento(@PathVariable("id")Long eventoId,
    					 HttpSession session,
    					 Model model,
    					 @ModelAttribute("mensaje")Mensaje mensaje) {
    	 Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
         if(usuarioTemporal == null) {
             return "redirect:/";
         }
         Evento evento = servicio.encontrarEvento(eventoId);
         model.addAttribute("evento", evento);
         
         return "evento.jsp";
    }
    @DeleteMapping("/borrar/{id}")
    public String Delete(@PathVariable("id")Long id) {
    	servicio.eliminarEvento(id);
    	return "redirect:/dashboard";
    }
    
    @GetMapping("/editar/{id}")
    public String editarEvento(@PathVariable("id") Long id, Model model,  HttpSession session) {
        Evento evento = servicio.encontrarEvento(id);
        
        Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
        if(usuarioTemporal == null) {
            return "redirect:/";
        }
        
        model.addAttribute("estados", Estado.Estados);
        
        model.addAttribute("editarEvento", evento);
        return "editar.jsp";
    }

    
    @PutMapping("/editar")
    public String guardarEdicion(@Valid @ModelAttribute("editarEvento") Evento editarEvento, HttpSession session, Model model) {
    
    	
    	  Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
          if(usuarioTemporal == null) {
              return "redirect:/";
           }
    
    	
        servicio.GuardarEvento(editarEvento);
        return "redirect:/dashboard";
    }

    @PostMapping("/crearmensaje")
    public String crearmensaje(@Valid @ModelAttribute("mensaje") Mensaje mensaje,
    						   BindingResult result,
    						   HttpSession session,
    						   Model model) {
    	
    	  Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
          if(usuarioTemporal == null) {
              return "redirect:/";
           }
          if(result.hasErrors()) {
        	  
        	  model.addAttribute("evento", mensaje.getEvento());
        	  return "evento.jsp";
          }else {
        	servicio.guardarMensaje(mensaje);
        	return "redirect:/evento/"+mensaje.getEvento().getId();
        	  }
          }
    	
    }
    
    

