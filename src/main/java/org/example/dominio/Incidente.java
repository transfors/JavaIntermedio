package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Incidente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIncidente;
    @ManyToOne
    private Cliente cliente;
    private String servicio;
    private String descripcion;
    private String tipoProblema;
    @ManyToOne
    private Tecnico tecnicoAsignado;
    private String fechaPosibleResolucion;
    private boolean incidenteIngresado = true;

    public Incidente() {
    }

    public Incidente(Cliente cliente, String servicio, String descripcion, String tipoProblema, Tecnico tecnicoAsignado, String fechaPosibleResolucion, boolean incidenteIngresado) {
        this.cliente = cliente;
        this.servicio = servicio;
        this.descripcion = descripcion;
        this.tipoProblema = tipoProblema;
        this.tecnicoAsignado = tecnicoAsignado;
        this.fechaPosibleResolucion = fechaPosibleResolucion;
        this.incidenteIngresado = incidenteIngresado;
    }

    public static void agregarIncidente(Incidente incidente1) {
    }

    public Long getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Long idIncidente) {
        this.idIncidente = idIncidente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getServicio() {
        return servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public Tecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(Tecnico tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public String getFechaPosibleResolucion() {
        return fechaPosibleResolucion;
    }

    public void setFechaPosibleResolucion(String fechaResolucion) {
        this.fechaPosibleResolucion = fechaResolucion;
    }

    public boolean isIncidenteIngresado() {
        return incidenteIngresado;
    }

    public void setIncidenteIngresado(boolean incidenteIngresado) {
        this.incidenteIngresado = incidenteIngresado;
    }

    @Override
    public String toString() {
        return "Incidente{" +
                "idIncidente=" + idIncidente +
                ", cliente=" + cliente +
                ", servicio='" + servicio + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipoProblema='" + tipoProblema + '\'' +
                ", tecnicoAsignado=" + tecnicoAsignado +
                ", fechaPosibleResolucion='" + fechaPosibleResolucion + '\'' +
                ", incidenteIngresado=" + incidenteIngresado +
                '}';
    }
}