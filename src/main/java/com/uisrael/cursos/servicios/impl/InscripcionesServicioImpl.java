package com.uisrael.cursos.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.Curso;
import com.uisrael.cursos.modelo.Estudiante;
import com.uisrael.cursos.modelo.Inscripcion;
import com.uisrael.cursos.repositorio.IInscripcionRepositorio;
import com.uisrael.cursos.servicios.IInscripcionesServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
@Service
@Component
public class InscripcionesServicioImpl implements IInscripcionesServicio{
	@Autowired
	IInscripcionRepositorio inscripcionesRepositorio;
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public void insertarInscripcion(Inscripcion nuevoInscripcion) {
		// TODO Auto-generated method stub
		try {
			inscripcionesRepositorio.save(nuevoInscripcion);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarInscripcion(Inscripcion editarInscripcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Inscripcion> listarInscripcion() {
		// TODO Auto-generated method stub
		return inscripcionesRepositorio.findAll();
	}
	 
    @Override
    public List<Inscripcion> buscarInscripcionesPorCursoYEstado(Curso curso, boolean estado) {
        String jpql = "SELECT i FROM Inscripcion i WHERE i.curso = :curso AND i.estadoInscripcion = :estado";
        TypedQuery<Inscripcion> query = entityManager.createQuery(jpql, Inscripcion.class);
        query.setParameter("curso", curso);
        query.setParameter("estado", estado);
        return query.getResultList();
    }

    @Override
    public List<Inscripcion> buscarInscripcionesPorFechaEntre(Date startDate, Date endDate) {
        String jpql = "SELECT i FROM Inscripcion i WHERE i.fechaInscripcion BETWEEN :startDate AND :endDate";
        TypedQuery<Inscripcion> query = entityManager.createQuery(jpql, Inscripcion.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    @Override
    public List<Inscripcion> buscarInscripcionesPorEstudianteOrdenadasPorFechaDesc(Estudiante estudiante) {
        String jpql = "SELECT i FROM Inscripcion i WHERE i.fkEstudiante = :estudiante ORDER BY i.fechaInscripcion DESC";
        TypedQuery<Inscripcion> query = entityManager.createQuery(jpql, Inscripcion.class);
        query.setParameter("estudiante", estudiante);
        return query.getResultList();
    }

	@Override
	public Inscripcion buscarInscripcionId(int idInscripcion) {
		return inscripcionesRepositorio.findById(idInscripcion).get();

	}

	@Override
	public boolean eliminarInscripcionId(int idInscripcion) {
		inscripcionesRepositorio.deleteById(idInscripcion);
		return true;
	}

}
