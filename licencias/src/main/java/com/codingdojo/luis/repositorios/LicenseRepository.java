package com.codingdojo.luis.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.luis.models.License;
import com.codingdojo.luis.models.Person;


@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	List<License> findAll();
}
