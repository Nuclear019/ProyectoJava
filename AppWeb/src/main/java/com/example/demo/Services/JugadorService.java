package com.example.demo.Services;

import com.example.demo.Model.Entities.Jugador;
import com.example.demo.Model.Repositories.JugadorRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @GetMapping("/")
    public List<Jugador> getJugadores(){
        List<Jugador> jugadores = jugadorRepository.findAll();
        return jugadores;
    }
}
