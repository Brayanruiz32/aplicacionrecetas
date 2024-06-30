package com.principal.aplicacionrecetas.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/tipo")
public class TipoViewController {

    @GetMapping()
    public String mostrarTipos(Model model){
        return "carpeta/archivo";
    }

    @GetMapping("/create")
    public String crearTipos(Model model){
        return "carpeta/archivo";
    }

    @GetMapping("/update")
    public String actualizarTipos(Model model){
        return "carpeta/archivo";
    }

}
