package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;
    private String nombreServicio;
    @OneToMany
//    @JoinColumn(name = "idIncidente", referencedColumnName = "idProblema")
    private List<Problema> tipoProblema = new ArrayList<>();

    public Servicio() {
    }

    public Servicio(String nombreServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
    }
    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public List<Problema> getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(List<Problema> tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    // METODO PARA AGREGAR LOS TIPOS DE PROBLEMAS
    public void agregarListaProblemas(Problema problema) {
        this.tipoProblema.add(problema);
    }

    @Override
    public String toString() {
        return "Servicio {" +
                "idServicio = " + idServicio +
                ", nombreServicio = '" + nombreServicio + '\'' +
                ", tipoProblema = " + tipoProblema +
                '}';
    }
}
