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
        return "roles/listar";
    }

    // @GetMapping("/{id}")
    // public String mostrarRol(Model model){
    //     return "carpeta/archivo";
    // }

    @GetMapping("/create")
    public String crearRoles(Model model){
        return "roles/crear";
    }

    @GetMapping("/update")
    public String actualizarRoles(Model model){
        return "roles/editar";
    }



}
