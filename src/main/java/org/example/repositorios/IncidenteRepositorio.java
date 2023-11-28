package org.example.repositorios;

import org.example.dominio.Incidente;
import org.example.utilidades.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class IncidenteRepositorio {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void guardarIncidente(Incidente nuevoIncidente) {
        session.beginTransaction();
        session.save(nuevoIncidente);
        session.getTransaction().commit();
    }

    public void actualizarIncidente(Incidente nuevoIncidente) {
        session.beginTransaction();
        session.saveOrUpdate(nuevoIncidente);
        session.getTransaction().commit();
    }

    public void eliminarIncidente(Incidente nuevoIncidente) {
        session.beginTransaction();
        session.delete(nuevoIncidente);
        session.getTransaction().commit();
    }

    public List<Incidente> getIncidentes() {
        return session.createQuery("from Incidente", Incidente.class).list();
    }

    public Incidente getFechaPosibleResolucion(String fechaResolucion) {
        List<Incidente> resultados = session.createQuery("from Incidente where fechaPosibleResolucion = :fechaResolucion", Incidente.class)
                .setParameter("fechaResolucion", fechaResolucion)
                .list();
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }
    public Incidente getIncidenteIngresado(boolean incIngresado) {
        return session.createQuery("from Incidente where true = :incIngresado", Incidente.class).setParameter("incIngresado", incIngresado).list().get(0);
    }

}