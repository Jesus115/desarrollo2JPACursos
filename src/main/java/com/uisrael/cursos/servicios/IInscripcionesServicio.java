package com.uisrael.cursos.servicios;

import java.util.Date;
import java.util.List;

import com.uisrael.cursos.modelo.Curso;
import com.uisrael.cursos.modelo.Estudiante;
import com.uisrael.cursos.modelo.Inscripcion;

public interface IInscripcionesServicio {
	public void insertarInscripcion(Inscripcion nuevoInscripcion);
	public void actualizarInscripcion(Inscripcion editarInscripcion);
	public List<Inscripcion> listarInscripcion();
	List<Inscripcion> buscarInscripcionesPorCursoYEstado(Curso curso, boolean estado);
	List<Inscripcion> buscarInscripcionesPorFechaEntre(Date startDate, Date endDate);
	List<Inscripcion> buscarInscripcionesPorEstudianteOrdenadasPorFechaDesc(Estudiante estudiante);
}
