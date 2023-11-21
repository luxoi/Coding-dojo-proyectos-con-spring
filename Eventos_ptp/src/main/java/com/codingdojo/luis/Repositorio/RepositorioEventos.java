package com.codingdojo.luis.Repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.luis.Modelos.Evento;

@Repository
public interface RepositorioEventos extends CrudRepository<Evento, Long>{
	List<Evento> findByEstado(String estado);
	
	List<Evento> findByEstadoIsNot(String estado);
}
