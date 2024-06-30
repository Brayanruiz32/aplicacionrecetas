package com.principal.aplicacionrecetas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.principal.aplicacionrecetas.entities.Rol;
import com.principal.aplicacionrecetas.services.IServices;

@RestController
@RequestMapping("/rol")
public class RolController implements IController<Rol>{

    @Autowired
    private IServices<Rol> rolService;

    @PostMapping("/create")
    public Rol crear(Rol nuevoRegistro) {
        return rolService.crear(nuevoRegistro);
    }

    @PutMapping("/update/{id}")
    public Rol editar(Long id, Rol nuevosDatos) {
        return rolService.actualizar(id, nuevosDatos);
    }
    @DeleteMapping("/delete/{id}")
    public void eliminar(Long id) {
        rolService.eliminar(id);
    }

    @GetMapping("/find/{id}")
    public Rol encontrar(Long id) {
        return rolService.encontrar(id);
    }

    @GetMapping("/find/all")
    public List<Rol> listar() {
        return rolService.listar();
    }
}
