package com.uisrael.cursos.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.CursoHasContenidos;
import com.uisrael.cursos.repositorio.ICursoHasContenidosRepositorio;
import com.uisrael.cursos.servicios.ICursoHasContenidoServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class CursoHasContenidoServicioImpl implements ICursoHasContenidoServicio{
	@Autowired
	ICursoHasContenidosRepositorio cursoHasContenidosRepositorio;
	@PersistenceContext
    private EntityManager entityManager;

    public List<CursoHasContenidos> buscarCursoHasContenidosPorCurso(int cursoId) {
        TypedQuery<CursoHasContenidos> query = entityManager.createNamedQuery("CursoHasContenidos.buscarPorCurso", CursoHasContenidos.class);
        query.setParameter("cursoId", cursoId);
        return query.getResultList();
    }

    public List<CursoHasContenidos> buscarCursoHasContenidosPorContenido(int contenidoId) {
        TypedQuery<CursoHasContenidos> query = entityManager.createNamedQuery("CursoHasContenidos.buscarPorContenido", CursoHasContenidos.class);
        query.setParameter("contenidoId", contenidoId);
        return query.getResultList();
    }

    public List<CursoHasContenidos> buscarCursoHasContenidosPorCursoYContenido(int cursoId, int contenidoId) {
        TypedQuery<CursoHasContenidos> query = entityManager.createNamedQuery("CursoHasContenidos.buscarPorCursoYContenido", CursoHasContenidos.class);
        query.setParameter("cursoId", cursoId);
        query.setParameter("contenidoId", contenidoId);
        return query.getResultList();
    }
	@Override
	public void insertarCursoHasContenidos(CursoHasContenidos nuevoCursoHasContenidos) {
		// TODO Auto-generated method stub
		try {
			cursoHasContenidosRepositorio.save(nuevoCursoHasContenidos);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void actualizarCursoHasContenidos(CursoHasContenidos editarCursoHasContenidos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CursoHasContenidos> listarCursoHasContenidos() {
		// TODO Auto-generated method stub
		return null;
	}

}
