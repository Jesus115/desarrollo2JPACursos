package com.uisrael.cursos.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.Estudiante;
@Service

public interface IEstudianteServicio {
	public void insertarEstudiante(Estudiante nuevoEstudiante);
	public void actualizarEstudiante(Estudiante editarEstudiante);
	public void eliminarEstudiante(Estudiante eliminarEstudiante);
	
	public List<Estudiante> listarEstudiante();
	Estudiante obtenerEstudiantePorId(Integer id);
	List<Estudiante> buscarEstudiantesPorNombreYApellido(String nombre, String apellido);
	List<Estudiante> buscarEstudiantesPorCedulaIniciandoCon(String prefix);
	List<Estudiante> buscarEstudiantesPorNombreOApellidoConteniendo(String cadena);
	public Estudiante buscarEstudianteId(int idEstudiante);
	public boolean eliminarEstudianteId(int idEstudiante);
}
