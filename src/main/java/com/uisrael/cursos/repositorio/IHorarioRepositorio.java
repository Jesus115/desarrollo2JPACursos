package com.uisrael.cursos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.cursos.modelo.Horario;

public interface IHorarioRepositorio extends JpaRepository<Horario, Integer> {

}
