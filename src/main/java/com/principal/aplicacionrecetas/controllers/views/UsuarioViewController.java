package com.principal.aplicacionrecetas.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/usuario")
public class UsuarioViewController {

    @GetMapping()
    public String mostrarUsuarios(Model model){
        return "carpeta/archivo";
    }

    @GetMapping("/create")
    public String crearUsuarios(Model model){
        return "carpeta/archivo";
    }

    @GetMapping("/update")
    public String actualizarUsuarios(Model model){
        return "carpeta/archivo";
    }

}
