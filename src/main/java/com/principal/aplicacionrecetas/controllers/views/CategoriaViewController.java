package com.principal.aplicacionrecetas.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/categoria")
public class CategoriaViewController {

    @GetMapping()
    public String mostrarCategorias(Model model){
        return "carpeta/archivo";
    }

    @GetMapping("/{id}")
    public String mostrarCategoria(Model model){
        return "carpeta/archivo";
    }


    @GetMapping("/create")
    public String crearCategoria(Model model){
        return "carpeta/archivo";
    }

    @GetMapping("/update")
    public String actualizarCategoria(Model model){
        return "carpeta/archivo";
    }
}
