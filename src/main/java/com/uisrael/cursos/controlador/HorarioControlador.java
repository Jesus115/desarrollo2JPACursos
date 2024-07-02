package com.uisrael.cursos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HorarioControlador {
	@GetMapping("/horarios")
	public String listarHorario() {
		return "/horarios/listaHorarios";//ruta fisica de pagina
	} 
	@GetMapping("/horario/nuevo")
	public String nuevoHorario() {
		return "/horarios/horarios";//ruta fisica de pagina
	}
}
