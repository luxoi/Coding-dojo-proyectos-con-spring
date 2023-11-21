package com.codingdojo.luis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HolaHumanoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaHumanoApplication.class, args);
	}
	@GetMapping("/")
	public String holaHumano() {
		return "<h1>¡Hello human!</h1> Welcome to Springboot!";
		
	}
	@GetMapping("/name/{nombre}")
	public String HelloName(@PathVariable("nombre")String nombre) {
		return "<h1>¡Hello "+nombre+"!</h1> Welcome to Springbootjejeje!";
	}

}
