package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelos.Contacto;

public interface RepositorioContactos extends CrudRepository<Contacto, Long>{
	
}
