package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelos.Dormitorio;

@Repository
public interface RepositorioDormitorios extends CrudRepository<Dormitorio, Long>{
	List<Dormitorio> findAll();
}
