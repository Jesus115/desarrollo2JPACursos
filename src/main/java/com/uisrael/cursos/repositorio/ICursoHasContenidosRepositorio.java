package com.uisrael.cursos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.cursos.modelo.CursoHasContenidos;

public interface ICursoHasContenidosRepositorio extends JpaRepository<CursoHasContenidos, Integer> {

}
