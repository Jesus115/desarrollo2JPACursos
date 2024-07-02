package com.uisrael.cursos.modelo;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Inscripcion  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  idInscripcion;
	
	@ManyToOne
    @JoinColumn(name = "estudiante_idEstudiante")
    private Estudiante fkEstudiante;
    
    @ManyToOne
    @JoinColumn(name = "curso_idCurso")
    private Curso curso;

    private Date fechaInscripcion;
    private boolean estadoInscripcion;
}
