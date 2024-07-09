package com.uisrael.cursos.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uisrael.cursos.modelo.Contenidos;

@Service

public interface IContenidoServicio {
	public void insertarContenidos(Contenidos nuevoContenidos);
	public void actualizarContenidos(Contenidos editarContenidos);
	public List<Contenidos> listarContenidos();
	public List<Contenidos> buscarContenidosPorTitulo(String titulo);
    public List<Contenidos> buscarContenidosPorDescripcionContiene(String descripcion);
    public List<Contenidos> buscarContenidosPorTipo(String tipo);
	public Contenidos buscarContenidoId(int idContenido);
	public boolean eliminarContenidoId(int idCurso);

}
