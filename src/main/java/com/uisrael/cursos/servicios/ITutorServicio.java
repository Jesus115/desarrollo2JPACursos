package com.uisrael.cursos.servicios;

import java.util.List;

import com.uisrael.cursos.modelo.Tutor;

public interface ITutorServicio {
	public void insertarTutor(Tutor nuevoTutor);
	public void actualizarTutor(Tutor editarTutor);
	public List<Tutor> listarTutor();
	public List<Tutor> buscarTutoresPorNombre(String nombre);
	public List<Tutor> buscarTutoresPorApellido(String apellido);
	public List<Tutor> buscarTutoresPorCorreo(String correo);
}
