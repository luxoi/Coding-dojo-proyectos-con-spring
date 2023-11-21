package com.codingdojo.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.Direccion;
import com.codingdojo.cynthia.modelos.Hobby;
import com.codingdojo.cynthia.modelos.Salon;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioDirecciones;
import com.codingdojo.cynthia.repositorios.RepositorioHobbies;
import com.codingdojo.cynthia.repositorios.RepositorioSalones;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired //No es una instancia
	private RepositorioUsuarios repoUsuarios;
	
	@Autowired
	private RepositorioDirecciones repoDir;
	
	@Autowired
	private RepositorioSalones repoSalones;
	
	@Autowired
	private RepositorioHobbies repoHobbies;
	
	
	//Me regrese una lista con todos los usuarios
	public List<Usuario> todosUsuarios() {
		return repoUsuarios.findAll();
	}
	
	//Guardamos un usuarios
	public Usuario guardarUsuario(Usuario nuevoUsuario) {
		return repoUsuarios.save(nuevoUsuario);
	}
	
	//Me regresara un usuario en base a su ID
	public Usuario buscarUsuario(Long id) {
		//SELECT * FROM usuarios WHERE id = <id>
		return repoUsuarios.findById(id).orElse(null);
		//Me regresa un usuario y si no lo encuentra null
	}
	
	//Borre un usuario en base a su ID
	//id = 1
	public void borrarUsuario(Long id) {
		repoUsuarios.deleteById(id); //DELETE FROM usuarios WHERE id = <id>
	}
	
	//Recibir una palabra
	//palabra = "na"
	public List<Usuario> buscarPorNombre(String palabra) {
		return repoUsuarios.findByNombreContaining(palabra);
	}
	
	public List<Usuario> top10() {
		return repoUsuarios.findTop10ByOrderByNombreAsc();
	}
	
	public Direccion guardarDireccion(Direccion nuevaDireccion) { //Regresa un obj direccion
		return repoDir.save(nuevaDireccion);
	}
	
	public List<Usuario> usuariosSinDireccion(){
		return repoUsuarios.findByDireccionIdIsNull();
	}
	
	public List<Salon> todosSalones() {
		return repoSalones.findAll();
	}
	
	public List<Hobby> todosHobbies() {
		return repoHobbies.findAll();
	}
	
	public Hobby buscarHobby(Long id) {
		return repoHobbies.findById(id).orElse(null);
	}
	
	/*
	 * usuario_id = 4
	 * hobby_id = 2
	 * miUsuario = buscarUsuario(4) = Obj(Juana de Arco)
	 * miHobby = buscarHobby(2) = Obj(Programar)
	 * listaHobbies = {}
	 * listaHobbies = {Programar}
	 * Guardamos a Juana de Arco
	 * 
	 */
	public void guardarUsuarioHobby(Long usuario_id, Long hobby_id) {
		//Obtenemos el objeto de usuario
		Usuario miUsuario = buscarUsuario(usuario_id);
		
		//Obtenemos el objeto de hobby
		Hobby miHobby = buscarHobby(hobby_id);
		
		//Lista de Hobbies del usuario
		List<Hobby> listaHobbies = miUsuario.getHobbies();
		listaHobbies.add(miHobby);
		
		/*
		 * List<Usuario> listaUsuarios = miHobby.getUsuarios();
		 * listaUsuarios.add(miUsuario);
		 * repoHobbies.save(miHobby);
		 */
		
		repoUsuarios.save(miUsuario); //Actualizamos usuario
		
	}
	
	public void quitarUsuarioHobby(Long usuario_id, Long hobby_id) {
		Usuario miUsuario = buscarUsuario(usuario_id);
		Hobby miHobby = buscarHobby(hobby_id);
		List<Hobby> listaHobbies = miUsuario.getHobbies();
		listaHobbies.remove(miHobby);
		repoUsuarios.save(miUsuario);
	}
	
}
