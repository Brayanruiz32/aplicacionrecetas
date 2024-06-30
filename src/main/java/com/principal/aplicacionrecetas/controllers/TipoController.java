package com.principal.aplicacionrecetas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.principal.aplicacionrecetas.entities.Tipo;
import com.principal.aplicacionrecetas.services.IServices;

@RestController
@RequestMapping("/tipo")
public class TipoController implements IController<Tipo> {

    @Autowired
    private IServices<Tipo> tipoServicio;

    @PostMapping("/create")
    public Tipo crear(Tipo nuevoRegistro) {
        return tipoServicio.crear(nuevoRegistro);
    }

    @PutMapping("/update/{id}")
    public Tipo editar(Long id, Tipo nuevosDatos) {
        return tipoServicio.actualizar(id, nuevosDatos);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(Long id) {
        tipoServicio.eliminar(id);
    }

    @GetMapping("/find/{id}")
    public Tipo encontrar(Long id) {
        return tipoServicio.encontrar(id);
    }

    @GetMapping("/find/all")
    public List<Tipo> listar() {
        return tipoServicio.listar();
    }
}
