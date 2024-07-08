package com.example.demo.Controller;

import com.example.demo.Model.Entities.Imagen;
import com.example.demo.Model.Entities.Jugador;
import com.example.demo.Services.ImageService;
import com.example.demo.Services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
@Controller
public class JugadorController {

    private final JugadorService jugadorService;
    private final ImageService imageService;
    @Autowired
    public JugadorController(JugadorService jugadorService, ImageService imageService) {
        this.jugadorService = jugadorService;
        this.imageService = imageService;
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
        List<Imagen> imagenes = imageService.getImages();

        modelAndView.addObject("jugadores", jugadores);
        modelAndView.addObject("imagenes", imagenes);

        return modelAndView;
    }
    @GetMapping("/jugadoresNBA/jugador")
    public ModelAndView obtenerJugadorPorId(@RequestParam("id") Long idJugador) {
        Jugador jugador = jugadorService.getJugadorById(idJugador);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Jugadores/JugadorDetalles");
        modelAndView.addObject("jugador", jugador);
        Imagen imagen = imageService.getImageByJugador(jugadorService.getJugadorById(idJugador));

        String base64Image = Base64.getEncoder().encodeToString(imagen.getImagen());
        modelAndView.addObject("imagen", base64Image);
        return modelAndView;
    }


}
