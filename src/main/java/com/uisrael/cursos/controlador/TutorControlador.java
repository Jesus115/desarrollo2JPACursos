package com.uisrael.cursos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.cursos.modelo.Inscripcion;
import com.uisrael.cursos.modelo.Tutor;
import com.uisrael.cursos.servicios.ITutorServicio;

@Controller

public class TutorControlador {
	@Autowired
	public ITutorServicio tutorServicio;
	
	@GetMapping("/tutores")
	public String listarTutor(Model model) {
		List<Tutor> listarTutor = tutorServicio.listarTutor();
		model.addAttribute("lista", listarTutor);
		return "/tutores/listaTutores";//ruta fisica de pagina
	} 
	@GetMapping("/tutor_nuevo")
	public String nuevoTutor(Model model) {
		model.addAttribute("nuevoTutor", new Tutor());
		return "/tutores/tutores";//ruta fisica de pagina
	}
	@PostMapping("/insertar_tutores")
	public String guardarTutor(@ModelAttribute("nuevoTutor") Tutor nuevoTutor) {
		tutorServicio.insertarTutor(nuevoTutor);
		return "redirect:/tutores";
		
	}
	@GetMapping("/editar_tutor/{idTutor}")
	public String editarTutor(@PathVariable(value="idTutor") int idTutor,Model model ){
		Tutor TutorRecuperado = tutorServicio.buscarTutorId(idTutor);
		model.addAttribute("nuevoTutor", TutorRecuperado);
		return "tutores/tutores";
	}
	@GetMapping("/eliminar_tutores/{idTutor}")
	public String eliminarTutor(@PathVariable(value="idTutor") int idTutor) {
		boolean TutorEliminado = tutorServicio.eliminarTutorId(idTutor);
		return "redirect:/tutores";
		
	}
}
