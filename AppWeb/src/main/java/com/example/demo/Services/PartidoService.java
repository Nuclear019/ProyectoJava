package com.example.demo.Services;

import com.example.demo.Model.Entities.Equipo;
import com.example.demo.Model.Entities.Partido;
import com.example.demo.Model.Repositories.JugadorRepository;
import com.example.demo.Model.Repositories.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {
    private final PartidoRepository partidoRepository;

    @Autowired
    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public List<Partido> getPartidoByEquipo(Equipo id){
        List<Partido> partido = partidoRepository.findDistinctByIdEquipoLocalOrderByFechaDesc(id);
        return partido;
    }
}
