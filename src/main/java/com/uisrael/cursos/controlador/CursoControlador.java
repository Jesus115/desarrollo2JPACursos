package com.uisrael.cursos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.cursos.modelo.Curso;
import com.uisrael.cursos.servicios.ICursoServicio;

@Controller
public class CursoControlador {
	@Autowired
	public ICursoServicio servicioCurso;
	//Listar
	@GetMapping("/listarcursos") 
	public String listarCurso(Model model) {
		List<Curso> listarCurso = servicioCurso.listarCurso();
		model.addAttribute("lista", listarCurso);
		return "cursos/listacursos";//ruta fisica de pagina
	} 
	@GetMapping("/curso_nuevo")
	public String nuevoCurso(Model model) {
		model.addAttribute("nuevoCurso", new Curso());

		return "cursos/cursos";//ruta fisica de pagina
	}
	@PostMapping("/insertar_curso")
	public String guardarCurso(@ModelAttribute("nuevoCurso") Curso nuevoCurso) {
		servicioCurso.insertarCurso(nuevoCurso);
		return "redirect:/listarcursos";
		
	}
	@GetMapping("/editar_curso/{idcurso}")
	public String editarCurso(@PathVariable(value="idcurso") int idCurso,Model model ){
		Curso cursoRecuperado = servicioCurso.buscarCursoId(idCurso);
		model.addAttribute("nuevoCurso", cursoRecuperado);
		return "cursos/cursos";
	}
	@GetMapping("/eliminar_curso/{idcurso}")
	public String eliminarCurso(@PathVariable(value="idcurso") int idCurso) {
		boolean cursoEliminado = servicioCurso.eliminarCursoId(idCurso);
		return "redirect:/cursos";
		
	}
}
