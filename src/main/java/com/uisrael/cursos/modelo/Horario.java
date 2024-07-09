package com.uisrael.cursos.modelo;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
@Data
@Entity
public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dia;
    private Time horaInicio;
    private Time horaFin;
    // Propiedades temporales para binding
    @Transient
    private String horaInicioStr;

    @Transient
    private String horaFinStr;

    // Métodos de conversión
    public void setHoraInicioStr(String horaInicioStr) {
        this.horaInicioStr = horaInicioStr;
        this.horaInicio = Time.valueOf(horaInicioStr + ":00");
    }

    public void setHoraFinStr(String horaFinStr) {
        this.horaFinStr = horaFinStr;
        this.horaFin = Time.valueOf(horaFinStr + ":00");
    }
}
