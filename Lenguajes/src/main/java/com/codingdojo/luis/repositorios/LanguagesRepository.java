package com.codingdojo.luis.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.luis.models.Language;

@Repository
public interface LanguagesRepository extends CrudRepository<Language, Long>{
 List<Language> findAll();
}
