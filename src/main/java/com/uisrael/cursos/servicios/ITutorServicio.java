package com.uisrael.cursos.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.Tutor;
@Service

public interface ITutorServicio {
	public void insertarTutor(Tutor nuevoTutor);
	public void actualizarTutor(Tutor editarTutor);
	public List<Tutor> listarTutor();
	public List<Tutor> buscarTutoresPorNombre(String nombre);
	public List<Tutor> buscarTutoresPorApellido(String apellido);
	public List<Tutor> buscarTutoresPorCorreo(String correo);
	public Tutor buscarTutorId(int idTutor);
	public boolean eliminarTutorId(int idTutor);
}
