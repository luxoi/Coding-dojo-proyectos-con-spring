package com.codingdojo.luis.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.luis.modelos.Dojo;
import com.codingdojo.luis.modelos.Ninja;
import com.codingdojo.luis.repositorios.RepositorioDojo;
import com.codingdojo.luis.repositorios.RepositorioNinja;

@Service
public class Servicio {
	@Autowired
	private RepositorioDojo repoDojo;
	@Autowired
	private RepositorioNinja repoNinja;
	
	public List<Ninja> findNinjas(){
		return repoNinja.findAll();
	}
	public Dojo guardarDojo(Dojo nuevoDojo) {
		return repoDojo.save(nuevoDojo);
	}
	public Ninja guardarNinja(Ninja nuevoNinja) {
		return repoNinja.save(nuevoNinja);
	}
	public List<Dojo> findDojo(){
		return repoDojo.findAll();
	}
	public Dojo findDojos(Long id) {
		return repoDojo.findById(id).orElse(null);
	}
	
}
