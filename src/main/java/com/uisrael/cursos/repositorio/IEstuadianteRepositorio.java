package com.uisrael.cursos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.cursos.modelo.Estudiante;

public interface IEstuadianteRepositorio extends JpaRepository<Estudiante, Integer> {
	/*@Query ("SELECT e FROM Estudiante e WHERE e.apellido = :apellido")
    List<Estudiante> findByApellido(@Param("apellido") String apellido);
	 @Query("SELECT e FROM Estudiante e WHERE e.edad > :edad")
	 List<Estudiante> findByEdadGreaterThan(@Param("edad") int edad);
	 @Query("SELECT e FROM Estudiante e ORDER BY e.nombre ASC")
	 List<Estudiante> findAllOrderByNombre();*/
}
