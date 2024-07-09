package com.uisrael.cursos.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.Contenidos;
import com.uisrael.cursos.repositorio.IContenidoRepositorio;
import com.uisrael.cursos.servicios.IContenidoServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class ContenidoServicioImpl implements IContenidoServicio {
	@Autowired
	IContenidoRepositorio contenidoRepositorio;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Contenidos> buscarContenidosPorTitulo(String titulo) {
        String jpql = "SELECT c FROM Contenidos c WHERE c.tituloContenido = :titulo";
        TypedQuery<Contenidos> query = entityManager.createQuery(jpql, Contenidos.class);
        query.setParameter("titulo", titulo);
        return query.getResultList();
    }

    public List<Contenidos> buscarContenidosPorDescripcionContiene(String descripcion) {
        String jpql = "SELECT c FROM Contenidos c WHERE c.descripcionContenido LIKE :descripcion";
        TypedQuery<Contenidos> query = entityManager.createQuery(jpql, Contenidos.class);
        query.setParameter("descripcion", "%" + descripcion + "%");
        return query.getResultList();
    }

    public List<Contenidos> buscarContenidosPorTipo(String tipo) {
        String jpql = "SELECT c FROM Contenidos c WHERE c.tipoContenido = :tipo";
        TypedQuery<Contenidos> query = entityManager.createQuery(jpql, Contenidos.class);
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }
	@Override
	public void insertarContenidos(Contenidos nuevoContenidos) {
		// TODO Auto-generated method stub
		try {
			contenidoRepositorio.save(nuevoContenidos);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarContenidos(Contenidos editarContenidos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contenidos> listarContenidos() {
		// TODO Auto-generated method stub
		return contenidoRepositorio.findAll();
	}

	@Override
	public Contenidos buscarContenidoId(int idContenido) {
		return contenidoRepositorio.findById(idContenido).get();

	}

	@Override
	public boolean eliminarContenidoId(int idCurso) {
		contenidoRepositorio.deleteById(idCurso);
		return true;
	}

	
	

}
