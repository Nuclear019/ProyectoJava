package com.example.demo.Controller;

import com.example.demo.Model.Entities.Equipo;
import com.example.demo.Services.EquipoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EquipoController {

    EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }


}
