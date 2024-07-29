package com.example.demo.Controller;

import com.example.demo.Services.EquipoService;
import com.example.demo.Services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GamesController {
    private final JugadorService jugadorService;
    private final EquipoService equipoService;
    @Autowired
    public GamesController(JugadorService jugadorService, EquipoService equipoService) {
        this.jugadorService = jugadorService;
        this.equipoService = equipoService;
    }

    @GetMapping("/nba-wordle")
    public String nbaWordle() {
        return "games/wordle";
    }
}
