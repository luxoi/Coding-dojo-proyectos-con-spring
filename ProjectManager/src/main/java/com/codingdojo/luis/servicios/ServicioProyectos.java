package com.codingdojo.luis.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.luis.modelos.Proyecto;
import com.codingdojo.luis.modelos.Usuario;
import com.codingdojo.luis.repositorios.RepositorioProyectos;
import com.codingdojo.luis.repositorios.RepositoriosUsuarios;

@Service
public class ServicioProyectos {
	
	@Autowired
	private RepositoriosUsuarios ru;
	
	@Autowired 
	private RepositorioProyectos rp;
	
	public Proyecto guardarProyecto(Proyecto nuevoProyecto) {
		return rp.save(nuevoProyecto);
	}
	
	public Usuario encontrarUsuario(Long id) {
		return ru.findById(id).orElse(null);
	}
	
	public Usuario guardarUsuario(Usuario usuario) {
		return ru.save(usuario);
	}
	
	public List<Proyecto> encuentraMisProyectos(Usuario usuarioEnSesion){
		return rp.findByUsuariosUnidosContains(usuarioEnSesion);	
	}
	public List<Proyecto> encontrarOtrosProyectos(Usuario usuarioEnSesion){
		return rp.findByUsuariosUnidosNotContains(usuarioEnSesion);
	}
	public Proyecto encontrarProyecto(Long id) {
		return rp.findById(id).orElse(null);
	}
	public void unirProyecto(Long usuarioId,Long proyectoId) {
		Usuario miUsuario	= encontrarUsuario(usuarioId);
		Proyecto proyectoAUnir = encontrarProyecto(proyectoId);
		
		proyectoAUnir.getUsuariosUnidos().add(miUsuario);
		rp.save(proyectoAUnir);
	}
	
	public void salirProyecto(Long usuarioId, Long proyectoId) {
		Usuario miUsuario	= encontrarUsuario(usuarioId);
		Proyecto proyectoAUnir = encontrarProyecto(proyectoId);
		
		proyectoAUnir.getUsuariosUnidos().remove(miUsuario);
		rp.save(proyectoAUnir);
	}
	
	
}
