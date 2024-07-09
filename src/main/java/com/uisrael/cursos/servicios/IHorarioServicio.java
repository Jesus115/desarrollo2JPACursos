package com.uisrael.cursos.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.Horario;
@Service

public interface IHorarioServicio {
	public void insertarHorario(Horario nuevoHorario);
	public void actualizarHorario(Horario editarHorario);
	public List<Horario> listarHorario();
	public Horario buscarHorarioId(int idHorario);
	public boolean eliminarHorarioId(int idHorario);
}
