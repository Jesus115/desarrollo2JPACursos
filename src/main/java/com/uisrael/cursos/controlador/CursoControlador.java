package com.uisrael.cursos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.cursos.modelo.Curso;
import com.uisrael.cursos.servicios.ICursoServicio;

@Controller
public class CursoControlador {
	@Autowired
	public ICursoServicio servicioCurso;
	@GetMapping("/cursos")
	public String listarCurso(Model model) {
		List<Curso> listarCurso = servicioCurso.listarCurso();
		model.addAttribute("lista", listarCurso);
		return "/cursos/listaCursos";//ruta fisica de pagina
	} 
	@GetMapping("/curso_nuevo")
	public String nuevoCurso() {
		return "/cursos/cursos";//ruta fisica de pagina
	}
}
