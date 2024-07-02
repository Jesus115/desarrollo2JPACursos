package com.uisrael.cursos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.cursos.modelo.Inscripcion;

public interface IInscripcionRepositorio extends JpaRepository<Inscripcion, Integer> {

}
