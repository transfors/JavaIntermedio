package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Tecnico extends Miembro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTecnico;
    private String nombre;
    public metodoContacto PrefNotificacion;
    @ManyToMany
    private List<Especialidad> especialidades = new ArrayList<>();
    @ManyToMany
//    @JoinColumn(name = "id", referencedColumnName = "idEstimacion")
    private List<Estimacion> cantHorasEstimadas = new ArrayList<>();

    public int[] IncidentesResueltos;
    public Tecnico(String nombre, metodoContacto notificacion) {
        this.nombre = nombre;
        this.PrefNotificacion = notificacion;
        this.IncidentesResueltos = new int[7];

    }
    public Tecnico(String gerardo, String notificación, Especialidad especialidad1, Estimacion estimacion1) {
    }

    public Long getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Long idTecnico) {
        this.idTecnico = idTecnico;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estimacion> getCantHorasEstimadas() {
        return cantHorasEstimadas;
    }

    public void setCantHorasEstimadas(List<Estimacion> cantHorasEstimadas) {
        this.cantHorasEstimadas = cantHorasEstimadas;
    }

    // METODO PARA AGREGAR LAS ESPECIALIDADES
    public void agregarEspecialidad(Especialidad especialidad) {
        this.especialidades.add(especialidad);
    }

    // METODO PARA AGREGAR CANTIDAD DE HORAS ESTIMADAS DE RESOLUCION
    public void agregarHorasEstimadasResolucion(Estimacion estimacion) {
        this.cantHorasEstimadas.add(estimacion);
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "idTecnico=" + idTecnico +
                ", nombre='" + nombre + '\'' +
                ", especialidades=" + especialidades +
                ", IncidentesResueltos=" + Arrays.toString(IncidentesResueltos) +
                ", metodoContacto=" + metodoContacto +
                '}';
    }
}
