package com.codingdojo.cynthia.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //APIs
@RequestMapping("/base")
public class ControladorBase {
	
	//Petición tipo GET
	//URLs deben de ser únicas, nombre de método TAMBIÉN debe ser único
	//@RequestMapping(value="/", method=RequestMethod.GET)
	//Petición de tipo get, y me permite obtener una URL y arrojar algo de regreso
	//  /base/
	@GetMapping("/") 
	public String home() {
		return "¡Hola desde SpringBoot!";
	}
	
	//   /base/despliega
	@GetMapping("/despliega")
	public String despliegaUsuarios() {
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso"};
		String respuesta = "";
		for(int i=0; i<usuarios.length; i++) {
			respuesta += "<h2>"+usuarios[i]+"</h2>";
		}
		return respuesta;
		
	}
	
	/*
	 * Usuario escribe en navegador: /hello?nombre=Elena
	 * name = Elena
	 * <h1>¡Hola Elena!</h1>
	 */
	@GetMapping("/hello")
	public String helloNombre(@RequestParam(value="nombre") String name) {
		
		return "<h1>¡Hola "+name+"!</h1>";
		
	}
	/*
	 * Usuario escribe en navegador: /hello2?nombre=Elena&apellido=De Troya
	 * name = Elena, lastName= De Troya
	 * <h1>¡Hola Elena De Troya!</h1>
	 */
	@GetMapping("/hello2")
	public String helloNombreApellido(@RequestParam(value="nombre") String name,
									  @RequestParam(value="apellido") String lastName) {
		
		return "<h1>¡Hola "+name+" "+lastName+"!</h1>";
	}
	
	/*
	 * Usuario escribe en navegador:/hola/Elena 
	 * name = Elena
	 * <h1>¡Hola Elena!</h1>
	 */
	@GetMapping("/hola/{nombre}")
	public String helloPath(@PathVariable("nombre") String name) {
		return "<h1>¡Hola "+name+"!</h1>";
	}
	/*
	 * Usuario escribe en navegador:/repite/Perrito/2
	 * palabra = Perrito, numero = 2
	 * respuesta = ""
	 * respuesta = Perrito 
	 * respuesta = Perrito Perrito 
	 */
	@GetMapping("/repite/{palabra}/{numero}")
	public String repite(@PathVariable("palabra") String palabra,
						 @PathVariable("numero") int numero) {
		String respuesta = "";
		
		for(int i=0; i<numero; i++) {
			respuesta+=palabra+" ";
		}
		
		return respuesta;
	}
	
}
