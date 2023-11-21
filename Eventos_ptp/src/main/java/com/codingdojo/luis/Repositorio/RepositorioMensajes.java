package com.codingdojo.luis.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.luis.Modelos.Mensaje;

@Repository
public interface RepositorioMensajes extends CrudRepository<Mensaje, Long>{

}
