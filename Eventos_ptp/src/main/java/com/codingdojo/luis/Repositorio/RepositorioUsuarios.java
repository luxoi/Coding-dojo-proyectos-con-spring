package com.codingdojo.luis.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.luis.Modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);
	
}
