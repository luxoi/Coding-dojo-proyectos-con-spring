package com.codingdojo.luis.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.luis.modelos.Usuario;
import com.codingdojo.luis.repositorios.RepositoriosUsuarios;

@Service
public class Servicios {
	@Autowired
	private RepositoriosUsuarios repoUsuarios;
	
	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		String contrasena = nuevoUsuario.getPassword();
		String confirmacion = nuevoUsuario.getConfirmacion();
			if(!contrasena.equals(confirmacion)) {
				result.rejectValue("confirmacion", "Matches", "Las contraseñas no coinciden");
			}
			String email = nuevoUsuario.getEmail();
			Usuario existeUsuario = repoUsuarios.findByEmail(email);
			if(existeUsuario != null) {
				result.rejectValue("email","Unique", "El correo ingresado ya se encuentra ingresado");
			}
			if(result.hasErrors()) {
				return null;
			} else {
				String contra_encriptada = BCrypt.hashpw(contrasena, BCrypt.gensalt());
				nuevoUsuario.setPassword(contra_encriptada);
				return repoUsuarios.save(nuevoUsuario);
			}
	}
	
	public Usuario login(String email, String password) {
		
		Usuario usuarioInicioSesion = repoUsuarios.findByEmail(email);
		if(usuarioInicioSesion == null) {
			return null;
		}
		if(BCrypt.checkpw(password, usuarioInicioSesion.getPassword())) {
			return usuarioInicioSesion;
			
		}else {
			return null;
		}
		
	}
}
