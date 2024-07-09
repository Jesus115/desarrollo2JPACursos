package com.uisrael.cursos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.cursos.modelo.Contenidos;
import com.uisrael.cursos.servicios.IContenidoServicio;

@Controller

public class ContenidoControlador {
	@Autowired
	public IContenidoServicio contServicio;
	@GetMapping("/contenido")
	public String listarContenido(Model model) {
		List<Contenidos> listarContenido = contServicio.listarContenidos();
		model.addAttribute("lista", listarContenido);
		return "/contenido/listaContenido";//ruta fisica de pagina
	} 
	@GetMapping("/contenido_nuevo")
	public String nuevoContenido(Model model) {
		model.addAttribute("nuevoContenido", new Contenidos());

		return "contenido/contenido";//ruta fisica de pagina
	}
	@PostMapping("/insertar_contenido")
	public String guardarContenido(@ModelAttribute("nuevoContenido") Contenidos nuevoContenido) {
		contServicio.insertarContenidos(nuevoContenido);
		return "redirect:/contenido";
		
	}
	@GetMapping("/editar_contenido/{idContenido}")
	public String editarContenido(@PathVariable(value="idContenido") int idContenido,Model model ){
		Contenidos ContenidoRecuperado = contServicio.buscarContenidoId(idContenido);
		model.addAttribute("nuevoContenido", ContenidoRecuperado);
		return "contenido/contenido";
	}
	@GetMapping("/eliminar_contenido/{idContenido}")
	public String eliminarContenido(@PathVariable(value="idContenido") int idContenido) {
		boolean ContenidoEliminado = contServicio.eliminarContenidoId(idContenido);
		return "redirect:/contenido";
		
	}
}
