package com.uisrael.cursos.servicios;

import java.util.List;

import com.uisrael.cursos.modelo.Horario;

public interface IHorarioServicio {
	public void insertarHorario(Horario nuevoHorario);
	public void actualizarHorario(Horario editarHorario);
	public List<Horario> listarHorario();
}
