package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTecnico;
    private String nombre;
    @OneToMany(mappedBy = "idEspecialidades")
    private List<Especialidad> especialidades = new ArrayList<>();
    private boolean disponible;
    private String notificaciones;
    @OneToMany
    private List<Estimacion> estimaciones = new ArrayList<>();

    public Tecnico() {
    }

    public Tecnico(String nombre, List<Especialidad> especialidades, boolean disponible, String notificaciones, List<Estimacion> estimaciones) {
        this.nombre = nombre;
        this.especialidades = especialidades;
        this.disponible = disponible;
        this.notificaciones = notificaciones;
        this.estimaciones = estimaciones;
    }

    public Long getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Long idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(String notificaciones) {
        this.notificaciones = notificaciones;
    }

    public List<Estimacion> getEstimaciones() {
        return estimaciones;
    }

    public void setEstimaciones(List<Estimacion> estimaciones) {
        this.estimaciones = estimaciones;
    }

    public void agregarEspecialidad(Especialidad especialidad3) {
    }

    public void agregarHorasEstimadasResolucion(Estimacion estimacion1) {
    }

    @Override
    public String toString() {
        return "Tecnico {" +
                "idTecnico = " + idTecnico +
                ", nombre = '" + nombre + '\'' +
                ", especialidades = " + especialidades +
                ", disponible = " + disponible +
                ", notificaciones = '" + notificaciones + '\'' +
                ", estimaciones = " + estimaciones +
                '}';
    }



}
