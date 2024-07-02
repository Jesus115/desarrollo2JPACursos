package com.uisrael.cursos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.cursos.modelo.Curso;


public interface ICursoRepositorio extends JpaRepository<Curso, Integer>{
	@Query("SELECT c FROM Curso c where c.nombre = :name")
	public List<Curso> traerTodosMisCursos(@Param("name")String name);
}
