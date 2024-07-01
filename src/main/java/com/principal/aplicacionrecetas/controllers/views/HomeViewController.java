package com.principal.aplicacionrecetas.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeViewController {


    @GetMapping("/comidas")
    public String mostrarComidas(Model model){
        return "web/comidas";
    }

    @GetMapping("/comidas/{id}")
    public String mostrarComida(Model model){
        return "web/comida";
    }

    //tipo=desayuno, almuerzo, cena
    @GetMapping("/comidas/{tipo_id}")
    public String mostrarPorTipo(Model model){
        return "web/comidaTipo";
    }
    //categoria=fitness, grasosa, salada
    @GetMapping("/comidas/{categoria_id}")
    public String mostrarPorCategoria(Model model){
        return "web/comidaCategoria";
    }
}
