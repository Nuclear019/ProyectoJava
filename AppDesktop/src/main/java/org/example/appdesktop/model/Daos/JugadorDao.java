package org.example.appdesktop.model.Daos;

import jakarta.persistence.EntityManager;
import org.example.appdesktop.model.Entities.Jugador;

import java.util.ArrayList;
import java.util.List;

public class JugadorDao implements Dao<Jugador> {
    EntityManager em;

    public JugadorDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public Jugador get(long id) {
        em.getTransaction().begin();
        Jugador jugador = em.find(Jugador.class, id);
        em.getTransaction().commit();
        return jugador;
    }

    @Override
    public void insert(Jugador object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Jugador object) {

    }



    @Override
    public void deleteAll() {

    }

    @Override
    public void update(Jugador object) {

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
    public List<Jugador> getAll() {
        List<Jugador> jugadores = new ArrayList<>();
        em.getTransaction().begin();
        jugadores = em.createQuery("SELECT j FROM Jugador j").getResultList();
        em.getTransaction().commit();
        return jugadores;
    }

    public Jugador getByNombre(String nombre) {
        em.getTransaction().begin();
        try {
            Jugador jugador = em.createQuery("SELECT j FROM Jugador j WHERE j.nombre = :nombre", Jugador.class).setParameter("nombre", nombre).getSingleResult();
            em.getTransaction().commit();
            return jugador;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;

        }
    }

    public Jugador getByNombreCompleto(String nombre, String apellido) {
        em.getTransaction().begin();
        try {
            Jugador jugador = em.createQuery("SELECT j FROM Jugador j WHERE j.nombre = :nombre AND j.apellido = :apellidos", Jugador.class).setParameter("nombre", nombre).setParameter("apellidos", apellido).getSingleResult();
            em.getTransaction().commit();
            return jugador;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }

    }
}

