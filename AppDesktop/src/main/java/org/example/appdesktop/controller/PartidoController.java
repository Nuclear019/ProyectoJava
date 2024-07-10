package org.example.appdesktop.controller;

import jakarta.persistence.EntityManager;
import org.example.appdesktop.model.Daos.EquipoDao;
import org.example.appdesktop.model.Daos.PartidoDao;
import org.example.appdesktop.model.Dtos.PartidoInfoDto;
import org.example.appdesktop.model.EMF;
import org.example.appdesktop.model.Entities.Equipo;
import org.example.appdesktop.model.Entities.Partido;

import java.util.ArrayList;
import java.util.List;

public class PartidoController {
    private PartidoDao partidoDao;
    private EntityManager entityManager;

    public PartidoController() {
        this.entityManager = EMF.get().createEntityManager();
        partidoDao = new PartidoDao(entityManager);
    }
    public List<PartidoInfoDto> buscarPartidos(long idEquipo) {

        List<Partido> partidos = partidoDao.findByIdEquipo(idEquipo);
        List<PartidoInfoDto> partidosDto= new ArrayList<>();
        for (Partido partido : partidos) {
            EquipoDao equipoDao = new EquipoDao(entityManager);
            Equipo equipoLocal = equipoDao.get(partido.getIdEquipoLocal());
            Equipo equipoVisitante = equipoDao.get(partido.getIdEquipoVisitante());

            PartidoInfoDto partidoInfoDto = new PartidoInfoDto(
                    (int)  partido.getIdPartido(),
                equipoLocal.getNombreCompleto(),
                equipoVisitante.getNombreCompleto(),
                String.valueOf(partido.getPeriodo()),
                partido.getPostemporada(),
                partido.getPuntosLocal(),
                partido.getPuntosVisitante(),
                partido.getTemporada(),
                String.valueOf(partido.getFecha())
            );




            partidosDto.add(partidoInfoDto);
        }
        return partidosDto;
    }
}
