package com.codingdojo.luis.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.luis.modelos.Dojo;

public interface RepositorioDojo extends CrudRepository<Dojo, Long>{
	public List<Dojo> findAll();
}
