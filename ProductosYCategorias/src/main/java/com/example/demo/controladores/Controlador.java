package com.example.demo.controladores;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Categoria;
import com.example.demo.modelo.Producto;
import com.example.demo.servicios.Servicios;

import jakarta.persistence.Id;
import jakarta.validation.Valid;

@Controller
public class Controlador {
	@Autowired
	private Servicios service;
	
	
	@GetMapping("/")
	public String index(Model model) {
		List<Producto> listaDeProductos = service.encontrarProducto();		
		model.addAttribute("productos", listaDeProductos);
		return "index.jsp";
	}
	
	@GetMapping("/new/product")
	public String newProduct(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "newproduct.jsp";
	}
	@PostMapping("/create/product")
	public String createProduct(@Valid @ModelAttribute("producto")Producto producto,
								BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		service.saveProducto(producto);
		return "redirect:/";
	}
	@GetMapping("/new/category")
	public String newCategory(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("categoria", categoria);
		return "newcategory.jsp";
	}
	@PostMapping("/create/category")
	public String createCategory(@Valid @ModelAttribute("categoria")Categoria categoria,
								BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		service.saveCategoria(categoria);
		return "redirect:/";
	}
	@GetMapping("/products/{id}")
	public String addCategory(@PathVariable("id")Long id,
							Model model,
							@ModelAttribute("categoria")Categoria categoria) {
		Producto producto = service.encontrarProductoEspecifico(id);
		List<Categoria> categorias = service.encontrarCategoria();
		
		model.addAttribute("producto", producto);
		model.addAttribute("categorias", categorias);
		return "products.jsp";
	}
	@PostMapping("/crear/unir")
	public String crearUnion(@Valid @ModelAttribute("categoria")Categoria categoria,
							 BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		service.saveCategoria(categoria);
		return "redirect:/";
	}
}
