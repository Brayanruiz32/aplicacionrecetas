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
        return "carpeta/archivo";
    }

    @GetMapping("/{id}")
    public String mostrarComida(Model model){
        return "carpeta/archivo";
    }

    @GetMapping("/{categoria}")
    public String mostrarPorCategoria(){
        return "carpeta/archivo";
    }

    @GetMapping("/create")
    public String crearComida(Model model){
        return "carpeta/archivo";
    }

    @GetMapping("/update")
    public String actualizarComida(Model model){
        return "carpeta/archivo";
    }




}
