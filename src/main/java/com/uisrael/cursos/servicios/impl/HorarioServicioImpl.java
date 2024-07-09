package com.uisrael.cursos.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.Horario;
import com.uisrael.cursos.repositorio.IHorarioRepositorio;
import com.uisrael.cursos.servicios.IHorarioServicio;

@Service

public class HorarioServicioImpl implements IHorarioServicio{

	@Autowired
	IHorarioRepositorio horariooRepositorio;

	@Override
	public void insertarHorario(Horario nuevoHorario) {
		// TODO Auto-generated method stub
		try {
			horariooRepositorio.save(nuevoHorario);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarHorario(Horario editarHorario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Horario> listarHorario() {
		// TODO Auto-generated method stub
		return horariooRepositorio.findAll();
	}

	@Override
	public Horario buscarHorarioId(int idHorario) {
		return horariooRepositorio.findById(idHorario).get();

	}

	@Override
	public boolean eliminarHorarioId(int idHorario) {
		horariooRepositorio.deleteById(idHorario);
		return true;
	}

}
