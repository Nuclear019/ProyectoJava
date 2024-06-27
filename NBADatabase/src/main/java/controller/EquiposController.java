package controller;

import jakarta.persistence.EntityManager;
import model.Daos.EquipoDao;
import model.Daos.PartidoDao;
import model.Dtos.EquipoInfoDto;
import model.EMF;
import model.Entities.Equipo;
import model.Entities.Partido;

import java.util.List;

public class EquiposController {
    EntityManager entityManager;
    EquipoDao equipoDao;
    PartidoDao partidoDao;

    public EquiposController( ) {
        this.entityManager = EMF.get().createEntityManager();
        equipoDao = new EquipoDao(entityManager);
        partidoDao = new PartidoDao(entityManager);
    }


    public List<Equipo> buscarEquipos() {
        return equipoDao.getAll();
    }

    public EquipoInfoDto getEquipobyId(long idEquipo) {
        Equipo equipo = equipoDao.get(idEquipo);
        List<Partido> listaPartidos = partidoDao.findByIdEquipo(idEquipo);

        EquipoInfoDto equipoInfoDto = new EquipoInfoDto(


                equipo.getIdEquipo(),
                equipo.getNombreCompleto(),
                equipo.getAbreviatura(),
                equipo.getNombre(),
                equipo.getCiudad(),
                equipo.getConferencia(),
                equipo.getDivision(),
                listaPartidos

        );


        return equipoInfoDto;
    }
}
