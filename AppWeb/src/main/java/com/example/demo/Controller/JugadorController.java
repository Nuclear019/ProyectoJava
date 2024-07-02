package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JugadorController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index"); // Nombre de la vista
        // Puedes agregar datos al modelo si es necesario
        // modelAndView.addObject("mensaje", "Hola desde el controlador!");
        return modelAndView;
    }
}
