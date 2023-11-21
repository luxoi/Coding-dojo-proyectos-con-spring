package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Producto;

public interface RepositoriosProductos extends CrudRepository<Producto, Long>{
	public List<Producto> findAll();
}
