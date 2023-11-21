package com.codingdojo.luis.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.luis.models.Language;
import com.codingdojo.luis.repositorios.LanguagesRepository;

@Service
public class LanguageService {
	@Autowired
	private LanguagesRepository langRepo;
	
	public Language saveLanguage(Language language) {
		return langRepo.save(language);
	}
	
	public Language findLanguage(Long id) {
		return langRepo.findById(id).orElse(null);
	}
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
	
	public List<Language> allLanguages(){
		return langRepo.findAll();
	}
}
