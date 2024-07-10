package org.example.appdesktop.model.Daos;

import jakarta.persistence.EntityManager;
import org.example.appdesktop.model.Entities.Partido;

import java.util.List;

public class PartidoDao implements Dao<Partido> {

    EntityManager em;

    public PartidoDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public Partido get(long id) {
        return null;
    }

    @Override
    public void insert(Partido object) {

    }

    @Override
    public void delete(Partido object) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(Partido object) {

    }


    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public List<Integer> getAllIds() {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    public List<Partido> findByIdEquipo(long idEquipo) {
        em.getTransaction().begin();
        List<Partido> partidos = em.createQuery("SELECT p FROM Partido p WHERE p.idEquipoLocal = :idEquipo OR p.idEquipoVisitante = :idEquipo order by p.fecha desc ", Partido.class)
                .setParameter("idEquipo", idEquipo)
                .getResultList();
        em.getTransaction().commit();
        return partidos;
    }
}
