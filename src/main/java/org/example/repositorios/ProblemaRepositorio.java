package org.example.repositorios;

import org.example.dominio.Problema;
import org.example.utilidades.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class ProblemaRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarProblema(Problema nuevoProblema) {
        session.beginTransaction();
        session.save(nuevoProblema);
        session.getTransaction().commit();
    }

    public void actualizarProblema(Problema nuevoProblema) {
        session.beginTransaction();
        session.saveOrUpdate(nuevoProblema);
        session.getTransaction().commit();
    }

    public void eliminarProblemaServicio(Problema nuevoProblema) {
        session.beginTransaction();
        session.delete(nuevoProblema);
        session.getTransaction().commit();
    }

    public List<Problema> getProblemas() {
        return session.createQuery("from Problema", Problema.class).list();
    }

    public Problema getNombreTipoProblema(String nombreTipoProblema){
        return session.createQuery("from Problema where nombreTipoProblema = :nombreTipoProblema", Problema.class).setParameter("nombreTipoProblema", nombreTipoProblema).list().get(0);
    }

    public Problema getHorasEstimadasResolucion(Integer horasEstimadasResolucion){
        return session.createQuery("from Problema where horasEstimadasResolucion = :horasEstimadasResolucion", Problema.class).setParameter("horasEstimadasResolucion", horasEstimadasResolucion).list().get(0);
    }

}
