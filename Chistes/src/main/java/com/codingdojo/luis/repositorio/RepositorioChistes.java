package com.codingdojo.luis.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.luis.modelos.Chiste;

@Repository
public interface RepositorioChistes extends CrudRepository<Chiste, Long>{
	List<Chiste> findAll();
	
	List<Chiste> findByTipo(String tipo);
}
