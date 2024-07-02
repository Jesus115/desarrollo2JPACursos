package com.uisrael.cursos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.cursos.modelo.Contenidos;

public interface IContenidoRepositorio extends JpaRepository<Contenidos, Integer> {

}
