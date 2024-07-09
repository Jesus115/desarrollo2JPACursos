package com.uisrael.cursos.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.CursoHasContenidos;
@Service

public interface ICursoHasContenidoServicio {
	public void insertarCursoHasContenidos(CursoHasContenidos nuevoCursoHasContenidos);
	public void actualizarCursoHasContenidos(CursoHasContenidos editarCursoHasContenidos);
	public List<CursoHasContenidos> listarCursoHasContenidos();
	public List<CursoHasContenidos> buscarCursoHasContenidosPorCurso(int cursoId);
	public List<CursoHasContenidos> buscarCursoHasContenidosPorContenido(int contenidoId);
	public List<CursoHasContenidos> buscarCursoHasContenidosPorCursoYContenido(int cursoId, int contenidoId);
}
