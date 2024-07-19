package com.example.demo.Controller;

import com.example.demo.Model.Entities.Equipo;
import com.example.demo.Services.EquipoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Base64;
import java.util.List;

@Controller
public class EquipoController {

    EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }


    @GetMapping("/equiposNBA")
    public ModelAndView getEquipos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("desarrollando");
        return modelAndView;
    }

    @GetMapping("/equiposNBA/equipo")
    public ModelAndView obtenerEquipoPorId(@RequestParam("id") Long idEquipo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("desarrollando");
        return modelAndView;
    }
}
