package com.codingdojo.luis.Servicios;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.luis.Modelos.Evento;
import com.codingdojo.luis.Modelos.Mensaje;
import com.codingdojo.luis.Modelos.Usuario;
import com.codingdojo.luis.Repositorio.RepositorioEventos;
import com.codingdojo.luis.Repositorio.RepositorioMensajes;
import com.codingdojo.luis.Repositorio.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired
	private RepositorioUsuarios ru;
	
	@Autowired
	private RepositorioEventos re;
	
	@Autowired
	private RepositorioMensajes rm;
	
	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		String contrasena = nuevoUsuario.getPassword();
		String confirmacion = nuevoUsuario.getConfirmacion();
			if(!contrasena.equals(confirmacion)) {
				result.rejectValue("confirmacion", "Matches", "Las contraseñas no coinciden");
			}
			String email = nuevoUsuario.getEmail();
			Usuario existeUsuario = ru.findByEmail(email);
			if(existeUsuario != null) {
				result.rejectValue("email","Unique", "El correo ingresado ya se encuentra ingresado");
			}
			if(result.hasErrors()) {
				return null;
			} else {
				String contra_encriptada = BCrypt.hashpw(contrasena, BCrypt.gensalt());
				nuevoUsuario.setPassword(contra_encriptada);
				return ru.save(nuevoUsuario);
			}
	}
	
	public Usuario login(String email, String password) {
		
		Usuario usuarioInicioSesion = ru.findByEmail(email);
		if(usuarioInicioSesion == null) {
			return null;
		}
		if(BCrypt.checkpw(password, usuarioInicioSesion.getPassword())) {
			return usuarioInicioSesion;
			
		}else {
			return null;
		}
	}
		
	
	public Evento GuardarEvento(Evento nuevoEvento) {
		return re.save(nuevoEvento);
	}
	
	public Usuario encontrarUsuario(Long id) {
		return ru.findById(id).orElse(null);
	}
	public List<Evento> eventosEnMiEstado(String estado){
		return re.findByEstado(estado);
	}
	public List<Evento> eventosOtrosEstados(String estado){
			return re.findByEstadoIsNot(estado);
	}
	public Evento encontrarEvento(Long id) {
		return re.findById(id).orElse(null);
	}
	public void unirEvento(Long usuarioId, Long eventoId) {
		Usuario miUsuario = encontrarUsuario(usuarioId);
		Evento miEvento = encontrarEvento(eventoId);
		
		miUsuario.getEventosAsistidos().add(miEvento);
		ru.save(miUsuario);
	}
	
	public void quitarEvento(Long usuarioId, Long eventoId) {
		Usuario miUsuario = encontrarUsuario(usuarioId);
		Evento miEvento = encontrarEvento(eventoId);
		
		miUsuario.getEventosAsistidos().remove(miEvento);
		ru.save(miUsuario);
	}
	public void eliminarEvento(Long id) {
		re.deleteById(id);
	}
	public Mensaje guardarMensaje(Mensaje nuevoMensaje) {
		  return rm.save(nuevoMensaje);
	  }
}
