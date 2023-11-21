package com.codingdojo.luis.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.luis.modelos.Respuesta;

@Repository
public interface RepositorioRespuestas extends CrudRepository<Respuesta, Long>{
	
}
