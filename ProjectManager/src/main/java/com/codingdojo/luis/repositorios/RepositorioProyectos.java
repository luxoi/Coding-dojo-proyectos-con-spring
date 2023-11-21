package com.codingdojo.luis.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.luis.modelos.Proyecto;
import com.codingdojo.luis.modelos.Usuario;

@Repository
public interface RepositorioProyectos extends CrudRepository<Proyecto, Long>{

	List<Proyecto> findByUsuariosUnidosContains(Usuario usuario);
	
	List<Proyecto> findByUsuariosUnidosNotContains(Usuario usuario);
	
}
