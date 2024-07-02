package com.uisrael.cursos.modelo;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity

public class HorarioHasCurso implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorarioCurso;
    @ManyToOne
    @JoinColumn(name = "curso_idCurso")
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "horario_idHorario")
    private Horario horario;
}
