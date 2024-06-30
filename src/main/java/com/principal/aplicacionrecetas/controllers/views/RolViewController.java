package com.principal.aplicacionrecetas.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/rol")
public class RolViewController {


    @GetMapping()
    public String mostrarRoles(Model model){
        return "carpeta/archivo";
    }

    @GetMapping("/create")
    public String crearRoles(Model model){
        return "carpeta/archivo";
    }

    @GetMapping("/update")
    public String actualizarRoles(Model model){
        return "carpeta/archivo";
    }



}
