package com.principal.aplicacionrecetas.controllers.views;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.principal.aplicacionrecetas.entities.Comida;
import com.principal.aplicacionrecetas.repositories.ComidaRepository;

@Controller
@RequestMapping("/home")
public class HomeViewController {

    @Autowired
    private ComidaRepository comidaRepository;


    @GetMapping("/comidas")
    public String mostrarComidas(Model model){

        return "home/comidas";
    }
    //home/comidas/comida/1
    @GetMapping("/comidas/comida/{id}")
    public String mostrarComida(Model model){

        return "home/comida";
    }

    //tipo=desayuno, almuerzo, cena
    @GetMapping("/comidas/tipo/{tipo}")
    public String mostrarPorTipo(Model model){
        return "home/comidaTipo";
    }


    //categoria=fitness, grasosa, salada
    @GetMapping("/comidas/categoria/{categoria}")
    public String mostrarPorCategoria(Model model){
        return "home/comidaCategoria";
    }
}
