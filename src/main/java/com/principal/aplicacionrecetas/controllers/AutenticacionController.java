package com.principal.aplicacionrecetas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.principal.aplicacionrecetas.dtos.login.LoginDTO;

@RestController 
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @GetMapping("/login")
    public String login(@RequestBody LoginDTO login){
        return null;
    }


    
}
