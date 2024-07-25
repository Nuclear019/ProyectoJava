package com.example.demo.Controller;

import com.example.demo.Model.Entities.Equipo;
import com.example.demo.Model.Entities.Partido;
import com.example.demo.Services.EquipoService;
import com.example.demo.Services.PartidoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Base64;
import java.util.List;

@Controller
public class EquipoController {

    EquipoService equipoService;
    PartidoService partidoService;

    public EquipoController(EquipoService  equipoService, PartidoService partidoService) {
        this.equipoService = equipoService;
        this.partidoService = partidoService;
    }


    @GetMapping("/equiposNBA")
    public ModelAndView getEquipos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Equipos/EquiposNBA");
        List<Equipo> equipos = equipoService.getEquipos();
        modelAndView.addObject("equipos", equipos);
        return modelAndView;
    }

    @GetMapping("/equiposNBA/equipo")
    public ModelAndView obtenerEquipoPorId(@RequestParam("id") Long idEquipo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Equipos/EquipoDetalles");
        Equipo equipo = equipoService.getEquipoById(idEquipo);
        modelAndView.addObject("equipo", equipo);

        List<Partido> partidos = partidoService.getPartidoByEquipo(equipo);
                modelAndView.addObject("partidos", partidos);
        return modelAndView;
    }


}
