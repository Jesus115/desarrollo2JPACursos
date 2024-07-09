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
import com.uisrael.cursos.modelo.Horario;
import com.uisrael.cursos.servicios.IHorarioServicio;

@Controller

public class HorarioControlador {
	@Autowired
	public IHorarioServicio horarioSrvicio;
	
	@GetMapping("/horarios")
	public String listarHorario(Model model) {
		List<Horario> listarHorario = horarioSrvicio.listarHorario();
		model.addAttribute("lista", listarHorario);
		return "/horarios/listaHorarios";//ruta fisica de pagina
	} 
	@GetMapping("/horario_nuevo")
	public String nuevoHorario(Model model) {
		model.addAttribute("nuevoHorario", new Horario());
		return "/horarios/horarios";//ruta fisica de pagina
	}
	@PostMapping("/insertar_horario")
	public String guardarHorario(@ModelAttribute("nuevoHorario") Horario nuevoHorario) {
		horarioSrvicio.insertarHorario(nuevoHorario);
		return "redirect:/horarios";
		
	}
	@GetMapping("/editar_horario/{idhorario}")
	public String editarhorario(@PathVariable(value="idhorario") int idhorario,Model model ){
		Horario horarioRecuperado = horarioSrvicio.buscarHorarioId(idhorario);
		model.addAttribute("nuevoHorario", horarioRecuperado);
		return "horarios/horarios";
	}
	@GetMapping("/eliminar_horario/{idhorario}")
	public String eliminarhorario(@PathVariable(value="idhorario") int idhorario) {
		boolean horarioEliminado = horarioSrvicio.eliminarHorarioId(idhorario);
		return "redirect:/horarios";
		
	}
}
