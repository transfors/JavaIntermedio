package org.example;

import org.example.dominio.*;
import org.example.repositorios.*;

//        Integrantes Grupo 3:
//        SANTIAGO MARTÍN TOLEDO AGUIRRE
//        JUAN IGNACIO MOURIÑO ATELA
//        ELIAS PUDDINI
//        NELLY IRIS HERRERO
//        WEFFER OSCAR
//        TOMAS TORANZOS

public class Main {
    public static void main(String[] args) {

        ClienteRepositorio repoCliente = new ClienteRepositorio();
        repoCliente.getClientes().forEach(System.out::println);

        Cliente c = repoCliente.getClientesPorCUIT("30-123456789-8");
        System.out.println(c);

        ServicioRepositorio repoServicio = new ServicioRepositorio();
        repoServicio.getServicios().forEach(System.out::println);

        Servicio s = repoServicio.getServiciosPorNombre("Mantenimiento de SAP");
        System.out.println(s);

        ProblemaRepositorio repoProblema = new ProblemaRepositorio();
        repoProblema.getProblemas().forEach(System.out::println);

        Problema p = repoProblema.getNombreTipoProblema("Resolución de Incidentes Críticos");
        System.out.println(p);

        TecnicoRepositorio repoTecnico = new TecnicoRepositorio();
        repoTecnico.getTecnicos().forEach(System.out::println);

        Tecnico t = repoTecnico.getNombreTecnico("Gerardo");
        System.out.println(t);

        EspecialidadesRepositorio repoEspecialidades = new EspecialidadesRepositorio();
        repoEspecialidades.getEspecialidades().forEach(System.out::println);

        EspecitEstimacionTipoProblema("Resolución de Incidentes Críticos");
        System.out.println(estimacionTipoProblema1);
        Especialidad e = repoEspecialidades.getNombreEspecialidad("Especialista en SAP");
        System.out.println(e);

        ProblemaRepositorio repoHoras = new ProblemaRepositorio();

        Problema h = repoHoras.getHorasEstimadasResolucion(5);
        System.out.println(h);

        IncidenteRepositorio repoIncidentes = new IncidenteRepositorio();
        repoIncidentes.getIncidentes().forEach(System.out::println);

        Incidente incident = repoIncidentes.getFechaPosibleResolucion("10-09-2024");
        System.out.println(incident);

        Incidente incidente = repoIncidentes.getIncidenteIngresado(true);
        System.out.println(incidente);

        EstimacionRepositorio repoEstimaciones = new EstimacionRepositorio();
        repoEstimaciones.getEstimacion().forEach(System.out::println);

        Estimacion estimacionTipoProblema1 = repoEstimaciones.getEstimacionTipoProblema()

        Estimacion estimacionCantHsEst1 = repoEstimaciones.getCantHsEst(8);
        System.out.println(estimacionCantHsEst1);

//
//        // TIPOS DE PROBLEMA
//        ProblemaRepositorio repoTipoProblema = new ProblemaRepositorio();
//
//        Problema tipoProblema1 = new Problema("Resolución de Incidentes Críticos", 5);
//        Problema tipoProblema2 = new Problema("Mantenimiento preventivo", 3);
//        Problema tipoProblema3 = new Problema("Soporte Técnico", 4);
//
//        repoTipoProblema.guardarProblema(tipoProblema1);
//        repoTipoProblema.guardarProblema(tipoProblema2);
//        repoTipoProblema.guardarProblema(tipoProblema3);
//
//
//        // SERVICIOS
//        ServicioRepositorio repoServicio = new ServicioRepositorio();
//
//        Servicio servicio1 = new Servicio("Mantenimiento de SAP");
//        Servicio servicio2 = new Servicio("Soporte para Aplicaciones Tango");
//        Servicio servicio3 = new Servicio("Asistencia en Sistemas Operativos Windows");
//
//        repoServicio.guardarServicio(servicio1);
//        repoServicio.guardarServicio(servicio2);
//        repoServicio.guardarServicio(servicio3);
//
//
//        // ESPECIALIDADES
//        EspecialidadesRepositorio repoEspecialidades = new EspecialidadesRepositorio();
//
//        Especialidad especialidad1 = new Especialidad("Especialista en SAP","Profesional con amplia experiencia");
//        Especialidad especialidad2 = new Especialidad("Técnico en Tango","Especializado en configuración de aplicaciones Tango");
//        Especialidad especialidad3 = new Especialidad("Experto en Windows","Experiencia en Sistemas Operativos Windows");
//
//        repoEspecialidades.guardarEspecialidades(especialidad1);
//        repoEspecialidades.guardarEspecialidades(especialidad2);
//        repoEspecialidades.guardarEspecialidades(especialidad3);
//
//
//        // CLIENTE
//        ClienteRepositorio repoCliente = new ClienteRepositorio();
//
//        Cliente cliente1 = new Cliente("Disco", "30-123456789-8");
//        Cliente cliente2 = new Cliente("Farmacity", "30-987654321-5");
//        Cliente cliente3 = new Cliente("Coto", "30-905621321-5");
//
//        repoCliente.guardarCliente(cliente1);
//        repoCliente.guardarCliente(cliente2);
//        repoCliente.guardarCliente(cliente3);
//
//        servicio1.agregarListaProblemas(tipoProblema1);
//        servicio2.agregarListaProblemas(tipoProblema2);
//        servicio3.agregarListaProblemas(tipoProblema3);
//
//        repoServicio.actualizarServicio(servicio1);
//        repoServicio.actualizarServicio(servicio2);
//        repoServicio.actualizarServicio(servicio3);
//
//        cliente1.agregarServiciosContratados(servicio1);
//        cliente1.agregarServiciosContratados(servicio2);
//        cliente3.agregarServiciosContratados(servicio3);
//
//        repoCliente.actualizarCliente(cliente1);
//        repoCliente.actualizarCliente(cliente3);
//
//
//        //ESTIMACION CANTIDAD DE HORAS ESTIMADAS POR EL TECNICO
//        EstimacionRepositorio repoEstimacion = new EstimacionRepositorio();
//
//        Estimacion estimacion1 = new Estimacion(5, "Mantenimiento preventivo");
//        Estimacion estimacion2 = new Estimacion(2, "Resolución de Incidentes Críticos");
//        Estimacion estimacion3 = new Estimacion(4, "Soporte Técnico");
//
//        repoEstimacion.actualizarEstimacion(estimacion1);
//        repoEstimacion.actualizarEstimacion(estimacion2);
//        repoEstimacion.actualizarEstimacion(estimacion3);
//
//
//        // TECNICOS
//        TecnicoRepositorio repoTecnico = new TecnicoRepositorio();
//
//        Tecnico tecnico1 = new Tecnico("Gerardo", "Nuevo Incidente");
//        Tecnico tecnico2 = new Tecnico("Rubén", "Nuevo Incidente");
//        Tecnico tecnico3 = new Tecnico("Sergio", "Nuevo Incidente");
//
//        repoTecnico.guardarTecnico(tecnico1);
//        repoTecnico.guardarTecnico(tecnico2);
//        repoTecnico.guardarTecnico(tecnico3);
//
//        tecnico1.agregarEspecialidad(especialidad3);
//        tecnico2.agregarEspecialidad(especialidad1);
//        tecnico3.agregarEspecialidad(especialidad2);
//
//        repoTecnico.actualizarTecnico(tecnico1);
//        repoTecnico.actualizarTecnico(tecnico2);
//        repoTecnico.actualizarTecnico(tecnico3);
//
//        tecnico1.agregarHorasEstimadasResolucion(estimacion1);
//        tecnico2.agregarHorasEstimadasResolucion(estimacion2);
//        tecnico3.agregarHorasEstimadasResolucion(estimacion2);
//
//        repoTecnico.actualizarTecnico(tecnico1);
//        repoTecnico.actualizarTecnico(tecnico2);
//        repoTecnico.actualizarTecnico(tecnico3);
//
//
//        // INCIDENTES
//        IncidenteRepositorio repoIncidente = new IncidenteRepositorio();
//
//        Incidente incidente1 = new Incidente(cliente1,"Mantenimiento de SAP","error grave","Resolución de Incidentes Críticos",tecnico1,"10-01-2023",true);
//        Incidente incidente2 = new Incidente(cliente2,"Soporte para Aplicaciones Tango","error grave","Mantenimiento preventivo",tecnico2,"10-04-2023",true);
//        Incidente incidente3 = new Incidente(cliente3,"Asistencia en Sistemas Operativos Windows","error grave","Soporte Técnico",tecnico3,"18-01-2023",true);
//
//        repoIncidente.guardarIncidente(incidente1);
//        repoIncidente.guardarIncidente(incidente2);
//        repoIncidente.guardarIncidente(incidente3);
//
//        Incidente.agregarIncidente(incidente1);
//        Incidente.agregarIncidente(incidente2);
//        Incidente.agregarIncidente(incidente3);
//
//        repoIncidente.actualizarIncidente(incidente1);
//        repoIncidente.actualizarIncidente(incidente2);
//        repoIncidente.actualizarIncidente(incidente3);

    }
}
