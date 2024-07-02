package com.uisrael.cursos.servicios;

import java.util.List;

import com.uisrael.cursos.modelo.Contenidos;
import com.uisrael.cursos.modelo.Curso;

import jakarta.persistence.Entity;

public interface IContenidoServicio {
	public void insertarContenidos(Contenidos nuevoContenidos);
	public void actualizarContenidos(Contenidos editarContenidos);
	public List<Contenidos> listarContenidos();
	public List<Contenidos> buscarContenidosPorTitulo(String titulo);
    public List<Contenidos> buscarContenidosPorDescripcionContiene(String descripcion);
    public List<Contenidos> buscarContenidosPorTipo(String tipo);
}
