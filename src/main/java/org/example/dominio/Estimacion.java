package org.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Estimacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstimacion;
    private Integer cantidadHorasEstimadas = 0;
    private String tipoProblema;

    public Estimacion() {
    }

    public Estimacion(Integer cantidadHorasEstimadas, String tipoProblema) {
        this.cantidadHorasEstimadas = cantidadHorasEstimadas;
        this.tipoProblema = tipoProblema;
    }

    public Long getIdEstimacion() {
        return idEstimacion;
    }

    public void setIdEstimacion(Long idEstimacion) {
        this.idEstimacion = idEstimacion;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public Integer getCantidadHorasEstimadas() {
        return cantidadHorasEstimadas;
    }

    public void setCantidadHorasEstimadas(Integer cantidadHorasEstimadas) {
        this.cantidadHorasEstimadas = cantidadHorasEstimadas;
    }

    @Override
    public String toString() {
        return "Estimacion {" +
                "idEstimacion = " + idEstimacion +
                ", cantidadHorasEstimadas = " + cantidadHorasEstimadas +
                ", tipoProblema = '" + tipoProblema + '\'' +
                '}';
    }
}
