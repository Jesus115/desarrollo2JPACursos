package com.uisrael.cursos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.cursos.modelo.Tutor;

public interface ITutorRepositorio extends JpaRepository<Tutor, Integer> {
	/* @Query("SELECT t FROM Tutor t WHERE t.nombre = :nombre")
	    List<Tutor> findByNombre(@Param("nombre") String nombre);
	 @Query("SELECT t FROM Tutor t WHERE t.especialidad = :especialidad")
	    List<Tutor> findByEspecialidad(@Param("especialidad") String especialidad);
	 @Query("SELECT t FROM Tutor t ORDER BY t.apellido ASC")
	    List<Tutor> findAllOrderByApellido();*/
}
