package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Contacto;
import com.example.demo.modelos.Dormitorio;
import com.example.demo.modelos.Estudiante;
import com.example.demo.repositorios.RepositorioContactos;
import com.example.demo.repositorios.RepositorioDormitorios;
import com.example.demo.repositorios.RepositorioEstudiantes;

@Service
public class Servicio {
	@Autowired
	private RepositorioContactos repoCont;
	@Autowired 
	private RepositorioEstudiantes repoEst;
	@Autowired RepositorioDormitorios repoDor;
	
	public Contacto saveCont(Contacto contacto) {
		return repoCont.save(contacto);
	}
	public Estudiante saveEst(Estudiante estudiante) {
		return repoEst.save(estudiante);
	}
	
	public List<Estudiante> mostrarEst(){
		return repoEst.findAll();
	}
	public Dormitorio saveDorm(Dormitorio dorm) {
		return repoDor.save(dorm);
	}
	public Dormitorio findDorm(Long id) {
		return repoDor.findById(id).orElse(null);
	}
	public void addStudentToDorm(Long did, Long sid) {
		Dormitorio dorm = findDorm(did);
		Estudiante estudiante = repoEst.findById(sid).orElse(null);
		
		estudiante.setDormitorio(dorm);
		repoEst.save(estudiante);
	}
	public void deleteStudentFromDorm(Long sid) {
		Estudiante estudiante = repoEst.findById(sid).orElse(null);
		
		estudiante.setDormitorio(null);
		repoEst.save(estudiante);
	}
	public List<Estudiante> findStudentWithoutDormitory(){
		return repoEst.findByDormitorioIsNull();
	}
	
	
}
