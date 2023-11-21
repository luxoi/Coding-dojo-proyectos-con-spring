package com.codingdojo.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Usuario;

//CRUD = Create Read Update Delete
@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
	
	List<Usuario> findAll(); //SELECT * FROM usuarios
	
	//INSERT INTO usuarios (nombre, apellido....) VALUES(Atributos del objeto usuario)
	//UPDATE usuarios SET nombre = Valor de objeto
	Usuario save(Usuario nuevoUsuario); //Recibimos objeto usuario
	
	//Existen en CrudRepo: findAll(), findById(id), save(Object ob), deleteById(id)
	
	//Queries dinámicos
	//SELECT * FROM usuarios WHERE email = <email que recibimos en el método>
	List<Usuario> findByEmail(String email);
	
	//SELECT * FROM usuarios WHERE nombre = <nombre que recibimos>
	List<Usuario> findByNombre(String nombre); 
	
	//SELECT * FROM usuarios WHERE nombre LIKE "<letras>%"
	List<Usuario> findByNombreStartingWith(String letras);
	
	//SELECT * FROM usuarios WHERE nombre LIKE "%<palabra>%"
	List<Usuario> findByNombreContaining(String palabra);
	
	//SELECT * FROM usuarios ORDER BY nombre ASC -> ORDER BY rating DESC
	List<Usuario> findTop10ByOrderByNombreAsc();
	
	//Regrese los usuarios que NO tienen dirección
	List<Usuario> findByDireccionIdIsNull();
	
}
