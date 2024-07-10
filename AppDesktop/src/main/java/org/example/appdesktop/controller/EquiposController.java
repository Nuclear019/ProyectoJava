package org.example.appdesktop.controller;

import jakarta.persistence.EntityManager;
import org.example.appdesktop.model.Daos.EquipoDao;
import org.example.appdesktop.model.Daos.PartidoDao;
import org.example.appdesktop.model.Dtos.EquipoInfoDto;
import org.example.appdesktop.model.EMF;
import org.example.appdesktop.model.Entities.Equipo;
import org.example.appdesktop.model.Entities.Partido;

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
