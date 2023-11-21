package com.codingdojo.cynthia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //Me permite mostrar URLs
public class ProyectoUsuariosPtpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoUsuariosPtpApplication.class, args);
	}

}
