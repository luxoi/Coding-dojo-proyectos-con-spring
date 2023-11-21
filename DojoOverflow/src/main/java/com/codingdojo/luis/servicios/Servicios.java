package com.codingdojo.luis.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.luis.modelos.Etiqueta;
import com.codingdojo.luis.modelos.Pregunta;
import com.codingdojo.luis.modelos.Respuesta;
import com.codingdojo.luis.repositorios.RepositorioEtiquetas;
import com.codingdojo.luis.repositorios.RepositorioPreguntas;
import com.codingdojo.luis.repositorios.RepositorioRespuestas;

@Service
public class Servicios {
	@Autowired
	private RepositorioPreguntas repoP;
	@Autowired
	private RepositorioRespuestas repoR;
	@Autowired
	private RepositorioEtiquetas repoE;
	
	public List<Pregunta> todasPreguntas(){
		return repoP.findAll();
	}
	public Pregunta guardarPreguntas(Pregunta nuevaPregunta) {
		return repoP.save(nuevaPregunta);
	}
	public Respuesta guardarRespuesta(Respuesta nuevaRespuesta) {
		return repoR.save(nuevaRespuesta);
	}
	public Etiqueta encuentraEtiqueta(String tema) {
		return repoE.findByTema(tema);
	}
	public Etiqueta guardarEtiqueta(Etiqueta nuevaEtiqueta) {
		return repoE.save(nuevaEtiqueta);
	}
	public Pregunta encuentraPregunta(Long id) {
		return repoP.findById(id).orElse(null);
	}
	
}
