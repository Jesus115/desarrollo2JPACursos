package com.uisrael.cursos.modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Data
@Entity
/*@Table(name = "tb_curso")*/
public class Curso  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  idCurso;
	private String  nombre;
	private String  descripcion;
	private double  costo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  fechaRegistro;
	private boolean  estado;
	@OneToMany(mappedBy = "fkCurso")
	private List< Inscripcion> ListaInscripciones=new ArrayList<>();
	
}
