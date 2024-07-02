package com.uisrael.cursos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.cursos.modelo.Tutor;

public interface ITutorRepositorio extends JpaRepository<Tutor, Integer> {

}
