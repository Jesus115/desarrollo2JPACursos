package com.uisrael.cursos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ContenidoControlador {
	@GetMapping("/contenido")
	public String listarContenido() {
		return "/contenido/listaContenido";//ruta fisica de pagina
	} 
	@GetMapping("/contenido_nuevo")
	public String nuevoContenido() {
		return "/contenido/contenido";//ruta fisica de pagina
	}
}
