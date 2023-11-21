package com.codingdojo.luis.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.luis.modelos.Chiste;
import com.codingdojo.luis.repositorio.RepositorioChistes;

@Service
public class Servicios {
	
	@Autowired
	private RepositorioChistes	repoChiste;

	public List<Chiste> muestraChistes(String tipo){
		return repoChiste.findByTipo(tipo);
	}
	
}
