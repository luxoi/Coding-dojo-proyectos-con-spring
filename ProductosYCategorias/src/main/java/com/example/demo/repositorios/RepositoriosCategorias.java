package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Categoria;

public interface RepositoriosCategorias extends CrudRepository<Categoria, Long>{
	public List<Categoria> findAll();
}
