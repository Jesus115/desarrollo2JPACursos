package com.uisrael.cursos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CursoControlador {
	@GetMapping("/cursos")
	public String listarCurso() {
		return "/cursos/listaCursos";//ruta fisica de pagina
	} 
	@GetMapping("/curso/nuevo")
	public String nuevoCurso() {
		return "/cursos/cursos";//ruta fisica de pagina
	}
}
