package com.uisrael.cursos.servicios;

import com.uisrael.cursos.modelo.Curso;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ICursoServicio {
	public void insertarCurso(Curso nContenido);
	public void actualizarCurso(Curso editarCurso);
	public List<Curso> listarCurso();
	public List<Curso> listarCursoTQ();
	public List<Curso> listarCursoParametro(String nombre);
	public List<Curso> traerTodosMisCursos(String name);
	public Curso buscarCursoId(int idCurso);
	public boolean eliminarCursoId(int idCurso);
	
}
