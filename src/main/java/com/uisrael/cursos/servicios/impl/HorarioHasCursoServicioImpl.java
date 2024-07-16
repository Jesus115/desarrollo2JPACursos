package com.uisrael.cursos.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.HorarioHasCurso;
import com.uisrael.cursos.repositorio.IHorarioHasCursoRepositorio;
import com.uisrael.cursos.servicios.IHorarioHasCursoServicio;

@Service
public class HorarioHasCursoServicioImpl implements IHorarioHasCursoServicio {
	@Autowired
	IHorarioHasCursoRepositorio horarioHasCursoRepositorio;

	@Override
	public void insertarHorarioHasCurso(HorarioHasCurso nuevoHorario) {
		// TODO Auto-generated method stub
		try {
			 horarioHasCursoRepositorio.save(nuevoHorario);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarHorarioHasCurso(HorarioHasCurso editarHorarioHasCurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HorarioHasCurso> listarHorarioHasCurso() {
		// TODO Auto-generated method stub
		return horarioHasCursoRepositorio.findAll();
	}

}
