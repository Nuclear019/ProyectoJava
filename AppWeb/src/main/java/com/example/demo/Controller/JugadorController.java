package com.example.demo.Controller;

import com.example.demo.Model.Entities.Jugador;
import com.example.demo.Services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Base64;
import java.util.List;

@Controller
public class JugadorController {

    private final JugadorService jugadorService;
    @Autowired
    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @GetMapping(value = "/jugadoresNBA")
    public ModelAndView getJugadores() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Jugadores/jugadoresTable");
        List<Jugador> jugadores = jugadorService.getJugadores();
        modelAndView.addObject("jugadores", jugadores);
        return modelAndView;
    }
    @GetMapping("/jugadoresNBA/jugador")
    public ModelAndView obtenerJugadorPorId(@RequestParam("id") Long idJugador) {
        Jugador jugador = jugadorService.getJugadorById(idJugador);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Jugadores/JugadorDetalles");
        modelAndView.addObject("jugador", jugador);
        if (jugador.getFoto() != null && jugador.getFoto().length > 0) {
            String imagenBase64 = Base64.getEncoder().encodeToString(jugador.getFoto());
            modelAndView.addObject("image", imagenBase64);
        }
        return modelAndView;
    }
}
