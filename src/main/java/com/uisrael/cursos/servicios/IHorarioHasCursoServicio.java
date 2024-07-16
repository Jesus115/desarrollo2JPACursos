package com.uisrael.cursos.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.CursoHasContenidos;
import com.uisrael.cursos.modelo.HorarioHasCurso;
@Service

public interface IHorarioHasCursoServicio {
	public void insertarHorarioHasCurso(HorarioHasCurso nuevoHorario);
	public void actualizarHorarioHasCurso(HorarioHasCurso editarHorarioHasCurso);
	public List<HorarioHasCurso> listarHorarioHasCurso();
}
