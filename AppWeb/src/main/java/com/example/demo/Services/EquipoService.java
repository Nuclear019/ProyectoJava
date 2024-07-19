package com.example.demo.Services;

import com.example.demo.Model.Entities.Equipo;
import com.example.demo.Model.Repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<Equipo> getEquipos(){
        List<Equipo> equipos = equipoRepository.findAll();
        return equipos;
    }
    public Equipo getEquipoById(Long id){
        Equipo equipo = equipoRepository.findById(id).orElse(null);
        return equipo;
    }
}
