package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Problema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProblema;
    private String nombreTipoProblema;
    private Integer horasEstimadasResolucion;

    public Problema() {
    }

    public Problema(String nombreTipoProblema, Integer horasEstimadasResolucion) {
        this.nombreTipoProblema = nombreTipoProblema;
        this.horasEstimadasResolucion = horasEstimadasResolucion;
    }

    public Long getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Long idProblema) {
        this.idProblema = idProblema;
    }

    public String getNombreTipoProblema() {
        return nombreTipoProblema;
    }

    public void setNombreTipoProblema(String nombreTipoProblema) {
        this.nombreTipoProblema = nombreTipoProblema;
    }

    public Integer getHorasEstimadasResolucion() {
        return horasEstimadasResolucion;
    }

    public void setHorasEstimadasResolucion(Integer horasEstimadasResolucion) {
        this.horasEstimadasResolucion = horasEstimadasResolucion;
    }

    @Override
    public String toString() {
        return "Problema {" +
                "idProblema = " + idProblema +
                ", nombreTipoProblema = '" + nombreTipoProblema + '\'' +
                ", horasEstimadasResolucion = " + horasEstimadasResolucion +
                '}';
    }
}