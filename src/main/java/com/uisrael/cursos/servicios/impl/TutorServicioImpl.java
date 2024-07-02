package com.uisrael.cursos.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.Tutor;
import com.uisrael.cursos.repositorio.ITutorRepositorio;
import com.uisrael.cursos.servicios.ITutorServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Service
public class TutorServicioImpl implements ITutorServicio {
	@Autowired
	ITutorRepositorio tutorRepositorio;

	@Override
	public void insertarTutor(Tutor nuevoTutor) {
		// TODO Auto-generated method stub
		try {
			tutorRepositorio.save(nuevoTutor);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarTutor(Tutor editarTutor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tutor> listarTutor() {
		// TODO Auto-generated method stub
		return null;
	}
	@PersistenceContext
    private EntityManager entityManager;

    public List<Tutor> buscarTutoresPorNombre(String nombre) {
        String sql = "SELECT * FROM tutor WHERE nombre = :nombre";
        Query query = entityManager.createNativeQuery(sql, Tutor.class);
        query.setParameter("nombre", nombre);
        return query.getResultList();
    }

    public List<Tutor> buscarTutoresPorApellido(String apellido) {
        String sql = "SELECT * FROM tutor WHERE apellido = :apellido";
        Query query = entityManager.createNativeQuery(sql, Tutor.class);
        query.setParameter("apellido", apellido);
        return query.getResultList();
    }

    public List<Tutor> buscarTutoresPorCorreo(String correo) {
        String sql = "SELECT * FROM tutor WHERE correo = :correo";
        Query query = entityManager.createNativeQuery(sql, Tutor.class);
        query.setParameter("correo", correo);
        return query.getResultList();
    }

}
