package com.example.demo.Controller;

import com.example.demo.Model.Classes.Draft;
import com.example.demo.Model.Entities.Imagen;
import com.example.demo.Model.Entities.Jugador;
import com.example.demo.Services.ImageService;
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
        modelAndView.setViewName("Jugadores/JugadoresNBA");

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
        Imagen imagen = imageService.getImageByJugador(jugadorService.getJugadorById(idJugador));
        byte[] logoEquipo = jugador.getIdEquipo().getLogoEquipo();
        if (jugador != null && jugador.getDraft() == null) {
            jugador.setDraft(new Draft()); // Asegúrate de que draft no sea null
        }

        if (logoEquipo == null){
            modelAndView.addObject("logoEquipo", null);
        }else{
            String base64ImageTeamLogo = Base64.getEncoder().encodeToString(logoEquipo);
            modelAndView.addObject("logoEquipo", base64ImageTeamLogo);
        }

        if (imagen ==null){
            modelAndView.addObject("imagen", null);
        }else{
            String base64ImagePlayer = Base64.getEncoder().encodeToString(imagen.getImagen());
            modelAndView.addObject("imagen", base64ImagePlayer);
        }
        return modelAndView;
    }



}
