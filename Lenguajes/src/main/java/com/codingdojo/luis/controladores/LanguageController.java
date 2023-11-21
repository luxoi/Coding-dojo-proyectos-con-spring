package com.codingdojo.luis.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.luis.models.Language;
import com.codingdojo.luis.servicios.LanguageService;

import jakarta.validation.Valid;

@Controller
public class LanguageController {

	@Autowired
	private LanguageService langService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("languages", langService.allLanguages());
		return "index.jsp";
	}
	@GetMapping("/new")
	public String newLanguage(@ModelAttribute("language") Language language) {
		return "new.jsp";
	}
	
	@PostMapping("/languages")
	public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult
			result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
			
		langService.saveLanguage(language);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id,Model model) {
		model.addAttribute("language", langService.findLanguage(id));
		return "edit.jsp";
	}
	@PutMapping("/update/{id}")
	public String update(@Valid @ModelAttribute("language")Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		langService.saveLanguage(language);
		return "redirect:/";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		langService.deleteLanguage(id);
		return "redirect:/";
	}
	
	
}
