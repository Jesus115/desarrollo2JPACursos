package com.uisrael.cursos.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.Curso;
import com.uisrael.cursos.repositorio.ICursoRepositorio;
import com.uisrael.cursos.servicios.ICursoServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class CursoServicioImpl implements ICursoServicio{
	 @PersistenceContext
    private EntityManager entityManager;
	@Autowired
	ICursoRepositorio cursoRepositorio;
	@Override
	public void insertarCurso(Curso nuevoCurso) {
		// TODO Auto-generated method stub
		try {
			cursoRepositorio.save(nuevoCurso);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarCurso(Curso editarCurso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Curso> listarCurso() {
		// TODO Auto-generated method stub		
		try {
			return cursoRepositorio.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Curso> listarCursoTQ() {
		try {
			String jpql = "SELECT c FROM Curso c";
	        TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
	        return query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Curso> listarCursoParametro(String nombre) {
		// TODO Auto-generated method stub
		try {
			 String jpql = "SELECT c FROM Curso c WHERE c.nombre LIKE :nombre";
		        TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
	        query.setParameter("nombre", "%" + nombre + "%");
	        return query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Curso> traerTodosMisCursos(String name) {
		// TODO Auto-generated method stub
		return cursoRepositorio.traerTodosMisCursos(name);
	}
	
	
}
