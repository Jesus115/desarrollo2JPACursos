package com.uisrael.cursos.modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class Estudiante  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  idEstudiante;
	private String  nombreEstudiante;
	private String  apellidoEstudiante;
	private String  cedulaEstudiante;
	private String  correoEstudiante;
	private String  direccionEstudiante;
	private boolean  estadoEstudiante;
	//@OneToMany(mappedBy = "fkEstudiante")
	//private List< Inscripcion> ListaInscripciones=new ArrayList<>();
}
