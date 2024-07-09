package com.uisrael.cursos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.uisrael.cursos.modelo.Estudiante;
import com.uisrael.cursos.servicios.IEstudianteServicio;

@Controller

public class EstudianteControlador {
	@Autowired
	public IEstudianteServicio estudianteServicio;
	
	@GetMapping("/estudiantes")
	public String listarEstudiante(Model model) {
		List<Estudiante> listarCurso = estudianteServicio.listarEstudiante();
		model.addAttribute("lista", listarCurso);
		return "/estudiantes/listaEstudiantes";//ruta fisica de pagina
	} 
	@GetMapping("/estudiante_nuevo")
	public String nuevoEstudiante(Model model) {
		model.addAttribute("nuevoEstudiante", new Estudiante());
		return "/estudiantes/estudiantes";//ruta fisica de pagina
	}
	@PostMapping("/insertar_estudiante")
	public String guardarEstudiante(@ModelAttribute("nuevoEstudiante") Estudiante nuevoEstudiante) {
		estudianteServicio.insertarEstudiante(nuevoEstudiante);
		return "redirect:/estudiantes";
	}
	@GetMapping("/editar_estudiante/{idEstudiante}")
	public String editarEstudiante(@PathVariable(value="idEstudiante") int idEstudiante,Model model ){
		Estudiante EstudianteRecuperado = estudianteServicio.buscarEstudianteId(idEstudiante);
		model.addAttribute("nuevoEstudiante", EstudianteRecuperado);
		return "estudiantes/estudiantes";
	}
	@GetMapping("/eliminar_estudiante/{idEstudiante}")
	public String eliminarEstudiante(@PathVariable(value="idEstudiante") int idEstudiante) {
		boolean EstudianteEliminado = estudianteServicio.eliminarEstudianteId(idEstudiante);
		return "redirect:/estudiantes";
		
	}
}
