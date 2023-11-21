package com.codingdojo.luis.controladores;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

		@GetMapping("/")
		public String home() {
			
			return "index.jsp";
		}
		
		@GetMapping("/date")
		public String date(Model model) {
			
			Date fecha = new Date();
			SimpleDateFormat formato = new SimpleDateFormat("EEEE, dd MMM, yyyy");
			String fecha_formateada = formato.format(fecha);
	
			model.addAttribute("fecha", fecha_formateada);
			
			return "date.jsp";
		}
		
		@GetMapping("/time")
		public String time(Model model) {
			Date fecha = new Date();
			SimpleDateFormat formato = new SimpleDateFormat("h:mm a");
			String hora_formateada = formato.format(fecha);
			
			model.addAttribute("hora", hora_formateada);
			
			return "time.jsp";
		}
}
