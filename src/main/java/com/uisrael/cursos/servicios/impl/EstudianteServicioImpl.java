package com.uisrael.cursos.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.Estudiante;
import com.uisrael.cursos.repositorio.IEstuadianteRepositorio;
import com.uisrael.cursos.servicios.IEstudianteServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class EstudianteServicioImpl implements IEstudianteServicio{
	 @PersistenceContext
    private EntityManager entityManager;
	@Autowired
	IEstuadianteRepositorio estudianteRepositorio;
	@Override
    public Estudiante obtenerEstudiantePorId(Integer id) {
        return estudianteRepositorio.findById(id).orElse(null);
    }
	@Override
	public void insertarEstudiante(Estudiante nuevoEstudiante) {
		// TODO Auto-generated method stub
		try {
			estudianteRepositorio.save(nuevoEstudiante);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarEstudiante(Estudiante editarEstudiante) {
		// TODO Auto-generated method stub
		try {
			estudianteRepositorio.save(editarEstudiante);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	@Override
    public void eliminarEstudiante(Estudiante eliminarEstudiante) {
		estudianteRepositorio.delete(eliminarEstudiante); 
    }
	@Override
	public List<Estudiante> listarEstudiante() {
		try {
			return estudianteRepositorio.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return null;
		}
	}
	@Override
    public List<Estudiante> buscarEstudiantesPorNombreYApellido(String nombre, String apellido) {
        String jpql = "SELECT e FROM Estudiante e WHERE e.nombreEstudiante = :nombre AND e.apellidoEstudiante = :apellido";
        TypedQuery<Estudiante> query = entityManager.createQuery(jpql, Estudiante.class);
        query.setParameter("nombre", nombre);
        query.setParameter("apellido", apellido);
        return query.getResultList();
    }
	@Override
    public List<Estudiante> buscarEstudiantesPorCedulaIniciandoCon(String prefix) {
        String jpql = "SELECT e FROM Estudiante e WHERE e.cedulaEstudiante LIKE :prefix";
        TypedQuery<Estudiante> query = entityManager.createQuery(jpql, Estudiante.class);
        query.setParameter("prefix", prefix + "%");
        return query.getResultList();
    }

    @Override
    public List<Estudiante> buscarEstudiantesPorNombreOApellidoConteniendo(String cadena) {
        String jpql = "SELECT e FROM Estudiante e WHERE e.nombreEstudiante LIKE :cadena OR e.apellidoEstudiante LIKE :cadena";
        TypedQuery<Estudiante> query = entityManager.createQuery(jpql, Estudiante.class);
        query.setParameter("cadena", "%" + cadena + "%");
        return query.getResultList();
    }
	
	
	

}
