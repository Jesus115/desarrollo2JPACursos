package com.uisrael.cursos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.cursos.modelo.HorarioHasCurso;

public interface IHorarioHasCursoRepositorio extends JpaRepository<HorarioHasCurso, Integer>{

}
