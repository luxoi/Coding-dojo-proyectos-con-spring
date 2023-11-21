package com.codingdojo.luis.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.luis.modelos.Usuario;

public interface RepositoriosUsuarios extends CrudRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);
	
}
