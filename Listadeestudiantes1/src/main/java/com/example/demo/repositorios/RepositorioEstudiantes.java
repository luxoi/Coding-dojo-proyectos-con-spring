package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelos.Estudiante;

public interface RepositorioEstudiantes extends CrudRepository<Estudiante, Long>{
	public List<Estudiante> findAll();

	  List<Estudiante> findByDormitorioIsNull();
}
