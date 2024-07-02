package model.Daos;

import jakarta.persistence.EntityManager;
import model.Entities.Imagen;

import java.util.List;

public class ImagenDao implements Dao<Imagen>{
    EntityManager em;

    public ImagenDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Imagen get(long id) {
        em.getTransaction().begin();
        Imagen imagen = em.find(Imagen.class, id);
        em.getTransaction().commit();
        return imagen;
    }

    @Override
    public void insert(Imagen object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Imagen object) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(Imagen object) {
        em.getTransaction().begin();
        em.createQuery("UPDATE Imagen i SET i.imagen = :imagen WHERE i.url = :url").setParameter("imagen", object.getImagen()).setParameter("url", object.getUrl()).executeUpdate();
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
    public List<Imagen> getAll() {
        return null;
    }
    public Imagen getImagenByJugadorId(long id){
        em.getTransaction().begin();
        try {
            Imagen imagen = (Imagen) em.createQuery("SELECT i FROM Imagen i WHERE i.idJugador.idJugador = :id").setParameter("id", id).getSingleResult();
            em.getTransaction().commit();
            return imagen;
        } catch (Exception e) {

            return null;
        }

    }

}
