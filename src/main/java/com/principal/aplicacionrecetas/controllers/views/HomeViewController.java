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
        return "carpeta/archivo";
    }

    @GetMapping("/comidas/{id}")
    public String mostrarComida(Model model){
        return "carpeta/archivo";
    }

    //tipo=desayuno, almuerzo, cena
    @GetMapping("/comidas/{tipo}")
    public String mostrarPorTipo(Model model){
        return "carpeta/archivo";
    }
    //categoria=fitness, grasosa, salada
    @GetMapping("/comidas/{categoria}")
    public String mostrarPorCategoria(Model model){
        return "carpeta/archivo";
    }
}
