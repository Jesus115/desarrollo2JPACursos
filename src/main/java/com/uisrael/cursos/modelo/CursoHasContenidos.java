package com.uisrael.cursos.modelo;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Data
@Entity
@NamedQueries({
    @NamedQuery(name = "CursoHasContenidos.buscarPorCurso", query = "SELECT cc FROM CursoHasContenidos cc WHERE cc.curso.idCurso = :cursoId"),
    @NamedQuery(name = "CursoHasContenidos.buscarPorContenido", query = "SELECT cc FROM CursoHasContenidos cc WHERE cc.contenidos.idContenidos = :contenidoId"),
    @NamedQuery(name = "CursoHasContenidos.buscarPorCursoYContenido", query = "SELECT cc FROM CursoHasContenidos cc WHERE cc.curso.idCurso = :cursoId AND cc.contenidos.idContenidos = :contenidoId")
})
public class CursoHasContenidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCursoContenido;
    
    @ManyToOne
    @JoinColumn(name = "curso_idCurso")
    private Curso curso;
    
    @ManyToOne
    @JoinColumn(name = "contenidos_idContenidos")
    private Contenidos contenidos;
    
}
