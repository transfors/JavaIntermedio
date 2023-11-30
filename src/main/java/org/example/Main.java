package org.example;

import org.example.dominio.*;
import org.example.repositorios.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//        Integrantes Grupo 3:
//        SANTIAGO MARTÍN TOLEDO AGUIRRE
//        JUAN IGNACIO MOURIÑO ATELA
//        ELIAS PUDDINI
//        NELLY IRIS HERRERO
//        WEFFER OSCAR
//        TOMAS TORANZOS

public class Main {

    TecnicoRepositorio repoTecnico = new TecnicoRepositorio(); IncidenteRepositorio repoIncidentes = new IncidenteRepositorio();
    RankingTecnicos lambdaMasIncidentesResueltos = n -> { // dada una lista de tecnicos, busca el que tenga mas incidentes resueltos.
        List<Tecnico> tecnicos = repoTecnico.getTecnicos();
        List<Incidente> incidentes = repoIncidentes.getIncidentes();
        Tecnico tecnicoTop = tecnicos.get(0);
        int topIncidentesResueltos = 0;
        for(Tecnico t: tecnicos ){
            List<Incidente> resueltosPorTecnico = incidentes.stream().filter(h -> h.ocurrioHaceNdias(n) && h.getTecnicoAsignado() == t ).collect(Collectors.toList());
            if (resueltosPorTecnico.size() > topIncidentesResueltos) {
                tecnicoTop = t;
                topIncidentesResueltos = resueltosPorTecnico.size();
            }
        }
        return tecnicoTop;
    };
    RankingTecnicosEspecialidad lambdaMasIncidentesResueltosEspecialidad = (n,e) -> { // dada una lista de tecnicos, busca el que tenga mas incidentes resueltos.
        List<Tecnico> tecnicos = repoTecnico.getTecnicos();
        List<Incidente> incidentes = repoIncidentes.getIncidentes();
        Tecnico tecnicoTop = tecnicos.get(0);
        int topIncidentesResueltos = 0;
        for(Tecnico t: tecnicos ){
            List<Incidente> resueltosPorTecnico = incidentes.stream().filter(h -> h.ocurrioHaceNdias(n) && h.getTecnicoAsignado() == t && h.especialidadCapacitada(e) ).collect(Collectors.toList());
            if (resueltosPorTecnico.size() > topIncidentesResueltos) {
                tecnicoTop = t;
                topIncidentesResueltos = resueltosPorTecnico.size();
            }
        }
        return tecnicoTop;
    };

    RankingTecnicos lambdaTecnicoMasRapido = (n) -> {
        List<Tecnico> tecnicos = repoTecnico.getTecnicos();
        List<Incidente> incidentes = repoIncidentes.getIncidentes();
        Tecnico tecnicoTop = tecnicos.get(0);
        float mejorPromedioTiempo = 0;
        for (Tecnico t: tecnicos) {
            List<Incidente> resueltosPorTecnico = incidentes.stream().filter(h -> h.ocurrioHaceNdias(n) && h.getTecnicoAsignado() == t).collect(Collectors.toList());
            float promedioTiempo = resueltosPorTecnico.stream().mapToLong(incidente -> incidente.getFechaResolucion() - incidente.getFechaCreacion()).boxed().collect(Collectors.summingLong(Long::longValue));
            if (promedioTiempo < mejorPromedioTiempo || mejorPromedioTiempo == 0){
                tecnicoTop = t;
                mejorPromedioTiempo = promedioTiempo;
            }
        }
        return tecnicoTop;
    };

    public static void main(String[] args) {

        ServicioRepositorio repoServicio = new ServicioRepositorio();
        repoServicio.getServicios().forEach(System.out::println);

        Servicio s = repoServicio.getServiciosPorNombre("Implementación y Actualización de Sistemas SAP");
        System.out.println(s);

        EspecialidadesRepositorio repoEspecialidades = new EspecialidadesRepositorio();
        repoEspecialidades.getEspecialidades().forEach(System.out::println);

        Especialidad e = repoEspecialidades.getNombreEspecialidad("Integración de Sistemas SAP");
        System.out.println(e);

        TipoProblemaRepositorio repoTipoProblema = new TipoProblemaRepositorio();
        repoTipoProblema.getTipoProblema().forEach(System.out::println);

        TipoProblema tp = repoTipoProblema.getTipoProblemaxnombre("Problemas de Configuración");
        System.out.println(tp);

        ProblemaRepositorio repoProblema = new ProblemaRepositorio();
        repoProblema.getProblemas().forEach(System.out::println);

        Problema p = repoProblema.getProblema("01/12/2023");
        System.out.println(p);

        ClienteRepositorio repoCliente = new ClienteRepositorio();
        repoCliente.getClientes().forEach(System.out::println);

        Cliente c = repoCliente.getClientesPorCUIT("30-123456789-8");
        System.out.println(c);

        EstimacionRepositorio repoEstimaciones = new EstimacionRepositorio();
        repoEstimaciones.getEstimacion().forEach(System.out::println);

        Estimacion est = repoEstimaciones.getEstimacionXCantHsEst(5);
        System.out.println(est);

        TecnicoRepositorio repoTecnico = new TecnicoRepositorio();
        repoTecnico.getTecnicos().forEach(System.out::println);

        Tecnico t = repoTecnico.getNombreTecnico("Gerardo");
        System.out.println(t);

        IncidenteRepositorio repoIncidentes = new IncidenteRepositorio();
        repoIncidentes.getIncidentes().forEach(System.out::println);

        Incidente inc = repoIncidentes.getIncidentesPorNombre("incidente1");
        System.out.println(inc);

/*
        // SERVICIOS
        ServicioRepositorio repoServicio = new ServicioRepositorio();

        Servicio servicio1 = new Servicio("Implementación y Actualización de Sistemas SAP", "Ofrecemos servicios completos desde la implementación inicial hasta las actualizaciones periódicas de sistemas SAP");
        Servicio servicio2 = new Servicio("Soporte Técnico Remoto para MacOS", "Brindamos asistencia técnica remota especializada para resolver problemas en entornos MacOS");
        Servicio servicio3 = new Servicio("Desarrollo de Aplicaciones Tango", "Nuestro servicio de desarrollo a medida crea aplicaciones Tango adaptadas a las necesidades únicas de su empresa");

        repoServicio.guardarServicio(servicio1);
        repoServicio.guardarServicio(servicio2);
        repoServicio.guardarServicio(servicio3);

        // ESPECIALIDADES

        List<Especialidad> especialidades = new ArrayList<>();
        EspecialidadesRepositorio repoEspecialidades = new EspecialidadesRepositorio();

        Especialidad especialidad1 = new Especialidad("Integración de Sistemas SAP","Dificultades en la integración de sistemas SAP con otras plataformas");
        Especialidad especialidad2 = new Especialidad("Conflictos de Compatibilidad en MacOS","Problemas de compatibilidad entre aplicaciones empresariales");
        Especialidad especialidad3 = new Especialidad("Errores en la Configuración de Aplicaciones Tango","Desafíos relacionados con la configuración incorrecta de aplicaciones Tango");

        repoEspecialidades.guardarEspecialidades(especialidad1);
        repoEspecialidades.guardarEspecialidades(especialidad2);
        repoEspecialidades.guardarEspecialidades(especialidad3);

        especialidad1.agregarEspecialidad(especialidad1);
        especialidad2.agregarEspecialidad(especialidad2);
        especialidad3.agregarEspecialidad(especialidad3);

        repoEspecialidades.actualizarEspecialidades(especialidad1);
        repoEspecialidades.actualizarEspecialidades(especialidad2);
        repoEspecialidades.actualizarEspecialidades(especialidad3);


        // TIPOS DE PROBLEMAS
        TipoProblemaRepositorio repoTipoProblema = new TipoProblemaRepositorio();

        TipoProblema tipoProblema1 = new TipoProblema("Problemas de Configuración","Dificultades relacionadas con la configuración inicial",4, especialidades);
        TipoProblema tipoProblema2 = new TipoProblema("Errores de Integración", "Desafíos asociados con la correcta integración de aplicaciones empresariales", 5, especialidades);
        TipoProblema tipoProblema3 = new TipoProblema("Conflictos de Software", "Problemas derivados de conflictos de software", 6, especialidades);

        repoTipoProblema.guardarTipoProblema(tipoProblema1);
        repoTipoProblema.guardarTipoProblema(tipoProblema2);
        repoTipoProblema.guardarTipoProblema(tipoProblema3);

        tipoProblema1.agregarTipoProblema(tipoProblema1);
        tipoProblema2.agregarTipoProblema(tipoProblema2);
        tipoProblema3.agregarTipoProblema(tipoProblema3);

       repoTipoProblema.actualizarTipoProblema(tipoProblema1);
        repoTipoProblema.actualizarTipoProblema(tipoProblema2);
        repoTipoProblema.actualizarTipoProblema(tipoProblema3);

        // PROBLEMAS
        ProblemaRepositorio repoProblema = new ProblemaRepositorio();

        Problema problema1 = new Problema(servicio1, tipoProblema1,"01/12/2023","14/12/2023","errores críticos");
        Problema problema2 = new Problema(servicio2, tipoProblema2, "02/12/2023","08/12/2023", "errores múltiples");
        Problema problema3 = new Problema(servicio3, tipoProblema3, "03/12/2023", "14/12/2023", "Software Obsoleto");

        repoProblema.guardarProblema(problema1);
        repoProblema.guardarProblema(problema2);
        repoProblema.guardarProblema(problema3);


        // CLIENTE
        ClienteRepositorio repoCliente = new ClienteRepositorio();

        Cliente cliente1 = new Cliente("Disco", "30-123456789-8");
        Cliente cliente2 = new Cliente("Farmacity", "30-987654321-5");
        Cliente cliente3 = new Cliente("Coto", "30-905621321-5");

        repoCliente.guardarCliente(cliente1);
        repoCliente.guardarCliente(cliente2);
        repoCliente.guardarCliente(cliente3);

        servicio1.agregarListaProblemas(tipoProblema1);
        servicio2.agregarListaProblemas(tipoProblema2);
        servicio3.agregarListaProblemas(tipoProblema3);

        repoServicio.actualizarServicio(servicio1);
        repoServicio.actualizarServicio(servicio2);
        repoServicio.actualizarServicio(servicio3);

        cliente1.agregarServiciosContratados(servicio1);
        cliente1.agregarServiciosContratados(servicio2);
        cliente3.agregarServiciosContratados(servicio3);

        repoCliente.actualizarCliente(cliente1);
        repoCliente.actualizarCliente(cliente3);


        //ESTIMACION CANTIDAD DE HORAS ESTIMADAS POR EL TECNICO
        EstimacionRepositorio repoEstimacion = new EstimacionRepositorio();

        Estimacion estimacion1 = new Estimacion(5, tipoProblema1);
        Estimacion estimacion2 = new Estimacion(2, tipoProblema2);
        Estimacion estimacion3 = new Estimacion(4, tipoProblema3);

        repoEstimacion.guardarEstimacion(estimacion1);
        repoEstimacion.guardarEstimacion(estimacion2);
        repoEstimacion.guardarEstimacion(estimacion3);

        estimacion1.agregarEstimacion(estimacion1);
        estimacion2.agregarEstimacion(estimacion2);
        estimacion3.agregarEstimacion(estimacion3);

        repoEstimacion.actualizarEstimacion(estimacion1);
        repoEstimacion.actualizarEstimacion(estimacion2);
        repoEstimacion.actualizarEstimacion(estimacion3);


        // TECNICOS
        TecnicoRepositorio repoTecnico = new TecnicoRepositorio();

        Tecnico tecnico1 = new Tecnico("Gerardo", especialidades,true,"notificación", Collections.singletonList(estimacion1));
        Tecnico tecnico2 = new Tecnico("Gerardo", especialidades,true,"notificación", Collections.singletonList(estimacion2));
        Tecnico tecnico3 = new Tecnico("Gerardo", especialidades,true,"notificación", Collections.singletonList(estimacion3));

        repoTecnico.guardarTecnico(tecnico1);
        repoTecnico.guardarTecnico(tecnico2);
        repoTecnico.guardarTecnico(tecnico3);

        tecnico1.agregarEspecialidad(especialidad3);
        tecnico2.agregarEspecialidad(especialidad1);
        tecnico3.agregarEspecialidad(especialidad2);

        repoTecnico.actualizarTecnico(tecnico1);
        repoTecnico.actualizarTecnico(tecnico2);
        repoTecnico.actualizarTecnico(tecnico3);

        tecnico1.agregarHorasEstimadasResolucion(estimacion1);
        tecnico2.agregarHorasEstimadasResolucion(estimacion2);
        tecnico3.agregarHorasEstimadasResolucion(estimacion2);

        repoTecnico.actualizarTecnico(tecnico1);
        repoTecnico.actualizarTecnico(tecnico2);
        repoTecnico.actualizarTecnico(tecnico3);


        // INCIDENTES
        IncidenteRepositorio repoIncidente = new IncidenteRepositorio();

        Incidente incidente1 = new Incidente("incidente1", Collections.singletonList(problema1),servicio1,tecnico1,EstadoIncidente.Abierto,"02/12/23","05/12/2023");
        Incidente incidente2 = new Incidente("incidente2", Collections.singletonList(problema2),servicio2,tecnico2,EstadoIncidente.En_proceso,"02/12/23","05/12/2023");
        Incidente incidente3 = new Incidente("incidente3", Collections.singletonList(problema3),servicio3,tecnico3,EstadoIncidente.Resuelto,"02/12/23","05/12/2023");

        repoIncidente.guardarIncidente(incidente1);
        repoIncidente.guardarIncidente(incidente2);
        repoIncidente.guardarIncidente(incidente3);

        Incidente.agregarIncidente(incidente1);
        Incidente.agregarIncidente(incidente2);
        Incidente.agregarIncidente(incidente3);

        repoIncidente.actualizarIncidente(incidente1);
        repoIncidente.actualizarIncidente(incidente2);
        repoIncidente.actualizarIncidente(incidente3);


*/
// funciones auxiliares

    }

}