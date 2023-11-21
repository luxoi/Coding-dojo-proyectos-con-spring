package com.codingdojo.luis.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.luis.modelos.Pregunta;
@Repository
public interface RepositorioPreguntas extends CrudRepository<Pregunta, Long>{
	
	List<Pregunta> findAll();

}
