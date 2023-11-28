package org.example.repositorios;

import org.example.dominio.Estimacion;
import org.example.utilidades.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class EstimacionRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarEstimacion(Estimacion nuevaEstimacion) {
        session.beginTransaction();
        session.save(nuevaEstimacion);
        session.getTransaction().commit();
    }

    public void actualizarEstimacion(Estimacion nuevaEstimacion) {
        session.beginTransaction();
        session.saveOrUpdate(nuevaEstimacion);
        session.getTransaction().commit();
    }

    public void eliminarEstimacion(Estimacion nuevaEstimacion) {
        session.beginTransaction();
        session.delete(nuevaEstimacion);
        session.getTransaction().commit();
    }

    public List<Estimacion> getEstimacion() {
        return session.createQuery("from Estimacion", Estimacion.class).list();
    }

    public Estimacion getEstimacionTipoProblema(String tipoProblema){
        return session.createQuery("from Estimacion where tipoProblema = :tipoProblema", Estimacion.class).setParameter("tipoProblema", tipoProblema).list().get(0);
    }

    public Estimacion getCantHsEst(Integer cantidadHorasEstimadas) {
        List<Estimacion> estimaciones = session.createQuery("from Estimacion where cantidadHorasEstimadas = :cantidadHorasEstimadas", Estimacion.class)
                .setParameter("cantidadHorasEstimadas", cantidadHorasEstimadas)
                .list();
        if (!estimaciones.isEmpty()) {
            return estimaciones.get(0);
        } else {
            return null;
        }
    }


}


