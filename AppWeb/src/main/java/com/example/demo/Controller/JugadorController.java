package com.example.demo.Controller;

import com.example.demo.Model.Entities.Jugador;
import com.example.demo.Services.JugadorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @GetMapping("/jugadores")
    public ModelAndView getJugadores() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Jugadores/jugadoresTable");
        List<Jugador> jugadores = jugadorService.getJugadores();
        modelAndView.addObject("jugadores", jugadores);
        return modelAndView;
    }
}
