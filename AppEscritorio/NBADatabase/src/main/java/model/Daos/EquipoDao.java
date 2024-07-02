package model.Daos;

import jakarta.persistence.EntityManager;
import model.Entities.Equipo;

import java.util.ArrayList;
import java.util.List;

public class EquipoDao implements Dao<Equipo> {
    EntityManager em;

    public EquipoDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Equipo get(long id) {
        em.getTransaction().begin();
        Equipo equipo = em.find(Equipo.class, id);
        em.getTransaction().commit();

        return equipo;
    }

    @Override
    public void insert(Equipo object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Equipo equipo) {
        em.getTransaction().begin();
        Equipo eq = em.find(Equipo.class, equipo.getIdEquipo());
            try {
                em.remove(eq);
            } catch (Exception e) {
                System.out.println("No existe el equipo que se quiere eliminar.");
            }
        em.getTransaction().commit();
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Equipo").executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public void update(Equipo object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
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
    public List<Equipo> getAll() {
        List<Equipo> equipos = new ArrayList<>();
        em.getTransaction().begin();
        List<Equipo>resultList = em.createQuery("SELECT e FROM Equipo e").getResultList();
        for (Equipo e : resultList) {
            if (!equipos.contains(e)) {
                equipos.add(e);

            }
        }
        em.getTransaction().commit();
        return equipos;
    }

    public Equipo getByName(String nombreEquipo) {
        em.getTransaction().begin();
        Equipo equipo = (Equipo) em.createQuery("SELECT e FROM Equipo e WHERE e.nombreCompleto = :nombreEquipo").setParameter("nombreEquipo", nombreEquipo).getSingleResult();
        em.getTransaction().commit();

        return equipo;
    }
}
