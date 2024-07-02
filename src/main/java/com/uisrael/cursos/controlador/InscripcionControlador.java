package com.uisrael.cursos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class InscripcionControlador {
	@GetMapping("/inscripciones")
	public String listarInscripciones() {
		return "/inscripciones/listaInscripciones";//ruta fisica de pagina
	} 
	@GetMapping("/inscripciones/nuevo")
	public String nuevoInscripciones() {
		return "/inscripciones/inscripciones";//ruta fisica de pagina
	}
}
