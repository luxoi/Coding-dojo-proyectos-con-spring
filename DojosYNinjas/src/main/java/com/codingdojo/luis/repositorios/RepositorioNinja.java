package com.codingdojo.luis.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.luis.modelos.Ninja;

public interface RepositorioNinja extends CrudRepository<Ninja, Long>{
	public List<Ninja> findAll();
}
