package com.principal.aplicacionrecetas.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/comida") 
public class ComidaViewController {

    @GetMapping()
    public String mostrarComidas(Model model){
        return "comidas/listar";
    }

    @GetMapping("/{id}")
    public String mostrarComida(Model model){
        return "comida";
    }

    @GetMapping("/create")
    public String crearComida(Model model){
        return "comidas/crear";
    }

    @GetMapping("/update")
    public String actualizarComida(Model model){
        return "comidas/actualizar";
    }




}
