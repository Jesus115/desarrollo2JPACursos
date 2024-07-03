package com.uisrael.cursos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class EstudianteControlador {
	@GetMapping("/estudiantes")
	public String listarEstudiante() {
		return "/estudiantes/listaEstudiantes";//ruta fisica de pagina
	} 
	@GetMapping("/estudiante_nuevo")
	public String nuevoEstudiante() {
		return "/estudiantes/estudiantes";//ruta fisica de pagina
	}
}
