package com.uisrael.cursos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class TutorControlador {
	@GetMapping("/tutores")
	public String listarTutor() {
		return "/tutores/listaTutores";//ruta fisica de pagina
	} 
	@GetMapping("/tutor/nuevo")
	public String nuevoTutor() {
		return "/tutores/tutores";//ruta fisica de pagina
	}
}
