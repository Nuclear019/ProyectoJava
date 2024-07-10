package org.example.appdesktop.controller;

import jakarta.persistence.EntityManager;
import org.example.appdesktop.model.Daos.ImagenDao;
import org.example.appdesktop.model.Daos.JugadorDao;
import org.example.appdesktop.model.EMF;
import org.example.appdesktop.model.Entities.Imagen;
import org.example.appdesktop.model.Entities.Jugador;

public class ImagenController {
    ImagenDao imagenDao;
    JugadorDao jugadorDao;

    public ImagenController() {
        EntityManager em = EMF.get().createEntityManager();
        this.imagenDao = new ImagenDao(em);
        this.jugadorDao = new JugadorDao(em);
    }
    public void addImagenJugador(String nombreJugador, byte[] bytesImagen) {
        Jugador jugador = jugadorDao.getByNombreCompleto(nombreJugador.split(" ")[0], nombreJugador.split(" ")[1]);
        Imagen imagen = new Imagen(jugador, "Imagen de jugador", "image/"+jugador.getNombre()+" "+jugador.getApellido(), bytesImagen);
        imagenDao.insert(imagen);
    }

    public void replaceImagenJugador(String nombreJugador, byte[] bytesImagen) {
        Jugador jugador = jugadorDao.getByNombreCompleto(nombreJugador.split(" ")[0], nombreJugador.split(" ")[1]);
        Imagen imagen = new Imagen(jugador, "Imagen de jugador", "image/"+jugador.getNombre()+" "+jugador.getApellido(), bytesImagen);
        imagenDao.update(imagen);
    }
}
