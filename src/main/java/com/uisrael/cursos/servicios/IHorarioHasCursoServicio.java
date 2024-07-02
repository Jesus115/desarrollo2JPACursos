package com.uisrael.cursos.servicios;

import java.util.List;

import com.uisrael.cursos.modelo.HorarioHasCurso;

public interface IHorarioHasCursoServicio {
	public void insertarHorarioHasCurso(HorarioHasCurso nuevoHorario);
	public void actualizarHorarioHasCurso(HorarioHasCurso editarHorarioHasCurso);
	public List<HorarioHasCurso> listarHorarioHasCurso();
}
