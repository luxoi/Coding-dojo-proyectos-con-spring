package com.codingdojo.luis.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.luis.models.License;
import com.codingdojo.luis.models.Person;
import com.codingdojo.luis.repositorios.LicenseRepository;
import com.codingdojo.luis.repositorios.PersonRepository;

import jakarta.validation.Valid;

@Service
public class ProjectService {
	@Autowired
	private LicenseRepository lRepo;
	@Autowired
	private PersonRepository pRepo;
	
	public Person savePerson(Person person) {
		return pRepo.save(person);
	}

	public License saveLicense(@Valid License license) {
		return lRepo.save(license);
	}
	public List<Person> findpeople(){
		return pRepo.findAll();
	}
	public Person findPerson(Long id) {
		return pRepo.findById(id).orElse(null); 
	}
}
