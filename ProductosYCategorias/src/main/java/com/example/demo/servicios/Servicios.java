package com.example.demo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Categoria;
import com.example.demo.modelo.Producto;
import com.example.demo.repositorios.RepositoriosCategorias;
import com.example.demo.repositorios.RepositoriosProductos;

@Service
public class Servicios {

	@Autowired
	private RepositoriosCategorias repoCategorias;
	@Autowired
	private RepositoriosProductos repoProductos;
	
	public Categoria saveCategoria(Categoria categoria) {
		return repoCategorias.save(categoria);
	}
	
	public Producto saveProducto(Producto producto) {
		return repoProductos.save(producto);
	}
	public List<Producto> encontrarProducto(){
		return repoProductos.findAll();
	}

	public List<Categoria> encontrarCategoria() {
		return repoCategorias.findAll();
	}
	public Producto encontrarProductoEspecifico(Long id){
		return repoProductos.findById(id).orElse(null);
	}
	public Categoria encontrarCategoria(Long id){
		return repoCategorias.findById(id).orElse(null);
	}
	public void juntarCategoriaYProducto(Long Producto_id, Long Categoria_id) {
		Producto miProducto = encontrarProductoEspecifico(Producto_id);
		Categoria miCategoria = encontrarCategoria(Categoria_id);
		
		miCategoria.getProductos().add(miProducto);
		repoCategorias.save(miCategoria);
	}
}
