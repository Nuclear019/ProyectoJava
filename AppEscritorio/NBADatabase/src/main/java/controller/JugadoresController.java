package controller;

import jakarta.persistence.EntityManager;
import model.Daos.EquipoDao;
import model.Daos.ImagenDao;
import model.Daos.JugadorDao;
import model.Classes.*;
import model.Entities.Equipo;
import model.Entities.Imagen;
import model.Entities.Jugador;
import model.Dtos.JugadorDto;

public class JugadoresController {

    EntityManager em;
    JugadorDao jugadorDao;
    EquipoDao equipoDao;
    ImagenDao imagenDao;

    public JugadoresController(EntityManager em) {
        this.em = em;
        this.jugadorDao = new JugadorDao(em);
        this.equipoDao = new EquipoDao(em);
        this.imagenDao = new ImagenDao(em);
    }



    public JugadorDto buscarJugadorporNombre(String nombre) {
        String[] nombreCompleto = nombre.split(" ");
        Jugador jugador;
        if (nombreCompleto.length == 1) {
            jugador = jugadorDao.getByNombre(nombreCompleto[0]);
        }
        else {
            jugador = jugadorDao.getByNombreCompleto(nombreCompleto[0], nombreCompleto[1]);
        }

        Equipo equipo = equipoDao.get(jugador.getIdEquipo().getIdEquipo());
        Imagen imagen = imagenDao.getImagenByJugadorId(jugador.getIdJugador());
        if (imagen == null) {
            imagen = new Imagen();

        }
        Draft draft = jugador.getDraft();



        JugadorDto jugadorDto = new JugadorDto(
                jugador.getIdJugador(),
                jugador.getNombre()+" "+jugador.getApellido(),
                equipo.getNombreCompleto(),
                jugador.getPosicion(),
                jugador.getAltura(),
                jugador.getPeso(),
                String.valueOf(jugador.getNumero()),
                draft.getAnoDraft(),
                draft.getRonda(),
                draft.getNumeroDraft(),
                jugador.getPais(),
                imagen.getImagen()

        );

        return jugadorDto;
    }

    public void changeImagenJugador(Long idJugador, byte[] bytesImagen) {
        Jugador jugador = jugadorDao.get(idJugador);
        jugador.setFoto(bytesImagen);
        Imagen imagen = imagenDao.getImagenByJugadorId(jugador.getIdJugador());
        if (imagen == null) {
            imagen = new Imagen(jugador, "Imagen de jugador", "image/"+jugador.getNombre()+" "+jugador.getApellido(), bytesImagen);
            imagenDao.insert(imagen);
            jugadorDao.update(jugador);
        }
        else {
            imagen.setImagen(bytesImagen);
            imagenDao.update(imagen);
            jugadorDao.update(jugador);

        }
    }
}
