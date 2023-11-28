package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Especialidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidades;
    private String nombreEspecialidad;
    private String descripcion;

    public Especialidad(String nombreEspecialidad, String descripcion) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.descripcion = descripcion;
    }

   public Long getIdEspecialidades() {
        return idEspecialidades;
    }

    public void setIdEspecialidades(Long idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Especialidades { " +
                ", nombre = '" + nombreEspecialidad + '\'' +
                ", descripcion = '" + descripcion + '\'' +
                '}';
    }
}
