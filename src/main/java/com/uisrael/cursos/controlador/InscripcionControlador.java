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
import com.uisrael.cursos.modelo.Estudiante;
import com.uisrael.cursos.modelo.Horario;
import com.uisrael.cursos.modelo.Inscripcion;
import com.uisrael.cursos.servicios.ICursoServicio;
import com.uisrael.cursos.servicios.IEstudianteServicio;
import com.uisrael.cursos.servicios.IInscripcionesServicio;

@Controller

public class InscripcionControlador {
	@Autowired
	public IInscripcionesServicio inscripcionService;
	@Autowired
	public ICursoServicio servicioCurso;
	@Autowired
	public IEstudianteServicio estudianteServicio;
	
	@GetMapping("/inscripciones")
	public String listarInscripciones(Model model) {
		List<Inscripcion> listarInscripcion = inscripcionService.listarInscripcion();
		model.addAttribute("lista", listarInscripcion);
		return "/inscripciones/listaInscripciones";//ruta fisica de pagina
	} 
	@GetMapping("/inscripciones_nuevo")
	public String nuevoInscripciones(Model model) {
		List<Curso> listarCurso = servicioCurso.listarCurso();
		List<Estudiante> listarEstudiante = estudianteServicio.listarEstudiante();
		model.addAttribute("listarEstudiantes", listarEstudiante);
		model.addAttribute("listarCursos", listarCurso);
		model.addAttribute("nuevoInscripciones", new Inscripcion());
		
		
		return "/inscripciones/inscripciones";//ruta fisica de pagina
	}
	@PostMapping("/insertar_inscripciones")
	public String guardarInscripciones(@ModelAttribute("nuevoInscripciones") Inscripcion nuevoInscripciones) {
		inscripcionService.insertarInscripcion(nuevoInscripciones);
		return "redirect:/inscripciones";
		
	}
	@GetMapping("/editar_inscripciones/{idInscripciones}")
	public String editarInscripciones(@PathVariable(value="idInscripciones") int idInscripciones,Model model ){
		Inscripcion inscripcionesRecuperado = inscripcionService.buscarInscripcionId(idInscripciones);
		List<Curso> listarCurso = servicioCurso.listarCurso();
		List<Estudiante> listarEstudiante = estudianteServicio.listarEstudiante();
		model.addAttribute("listarEstudiantes", listarEstudiante);
		model.addAttribute("listarCursos", listarCurso);
		model.addAttribute("nuevoInscripciones", inscripcionesRecuperado);
		return "inscripciones/inscripciones";
	}
	@GetMapping("/eliminar_inscripciones/{idInscripciones}")
	public String eliminarInscripciones(@PathVariable(value="idInscripciones") int idInscripciones) {
		boolean InscripcionesEliminado = inscripcionService.eliminarInscripcionId(idInscripciones);
		return "redirect:/inscripciones";
		
	}
}
