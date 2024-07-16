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
import com.uisrael.cursos.modelo.Curso;
import com.uisrael.cursos.modelo.CursoHasContenidos;
import com.uisrael.cursos.modelo.Horario;
import com.uisrael.cursos.modelo.HorarioHasCurso;
import com.uisrael.cursos.servicios.ICursoServicio;
import com.uisrael.cursos.servicios.IHorarioHasCursoServicio;
import com.uisrael.cursos.servicios.IHorarioServicio;
import com.uisrael.cursos.servicios.IContenidoServicio;
import com.uisrael.cursos.servicios.ICursoHasContenidoServicio;

@Controller
public class CursoControlador {
	@Autowired
	public ICursoServicio servicioCurso;
	@Autowired
	public ICursoHasContenidoServicio cursoContenido;
	@Autowired
	public IContenidoServicio contServicio;
	@Autowired
	public IHorarioHasCursoServicio servicioHorarioCurso;
	@Autowired
	public IHorarioServicio horarioSrvicio;
	//Listar
	@GetMapping("/listarcursos") 
	public String listarCurso(Model model) {
		List<Curso> listarCurso = servicioCurso.listarCurso();
		model.addAttribute("lista", listarCurso);
		return "cursos/listacursos";//ruta fisica de pagina
	} 
	
	@GetMapping("/cursos_horarios")
	public String cursosHorarios(Model model) {
		List<HorarioHasCurso> listarCursoHorarios = servicioHorarioCurso.listarHorarioHasCurso();
		model.addAttribute("lista", listarCursoHorarios);
		return "cursoHorarios/listaCursoHorario";//ruta fisica de pagina
	} 
	@GetMapping("/cursos_contenido")
	public String cursosContenidos(Model model) {
		List<CursoHasContenidos> listarCursoContenido = cursoContenido.listarCursoHasContenidos();
		model.addAttribute("lista", listarCursoContenido);
		return "cursoContenido/listarCursoContenido";//ruta fisica de pagina
	}
	@GetMapping("/curso_contenido_nuevo")
	public String nuevoContenidoCurso(Model model) {
		List<Curso> listarCurso = servicioCurso.listarCurso();
		List<Contenidos> listarContenido = contServicio.listarContenidos();
		model.addAttribute("listarCurso", listarCurso);
		model.addAttribute("listarContenido", listarContenido);
		model.addAttribute("nuevoCursoContenido", new CursoHasContenidos());
		return "cursoContenido/insercion";//ruta fisica de pagina
	}
	@GetMapping("/curso_horario_nuevo")
	public String nuevoHorarioCurso(Model model) {
		List<Curso> listarCurso = servicioCurso.listarCurso();
		List<Horario> listarHorario = horarioSrvicio.listarHorario();
		model.addAttribute("listarCurso", listarCurso);
		model.addAttribute("listarHorario", listarHorario);
		model.addAttribute("nuevoCursoHorario", new HorarioHasCurso());
		return "cursoHorarios/insercion";//ruta fisica de pagina
	}
	
	@GetMapping("/curso_nuevo")
	public String nuevoCurso(Model model) {
		model.addAttribute("nuevoCurso", new Curso());

		return "cursos/cursos";//ruta fisica de pagina
	}
	@PostMapping("/insertar_curso_contenido")
	public String guardarCursoContenido(@ModelAttribute("nuevoCursoContenido") CursoHasContenidos nuevoCursoContenido) {
		cursoContenido.insertarCursoHasContenidos(nuevoCursoContenido);
		return "redirect:/cursos_contenido";
	}
	@PostMapping("/insertar_curso_horario")
	public String guardarCursoHorarios(@ModelAttribute("nuevoCursoHorario") HorarioHasCurso nuevoCursoHorario) {
		servicioHorarioCurso.insertarHorarioHasCurso(nuevoCursoHorario);
		return "redirect:/cursos_horarios";
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
