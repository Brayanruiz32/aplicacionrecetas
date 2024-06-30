package com.principal.aplicacionrecetas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.principal.aplicacionrecetas.entities.Categoria;
import com.principal.aplicacionrecetas.services.IServices;

@RestController
@RequestMapping("/categoria")
public class CategoriaController implements IController<Categoria> {

    @Autowired
    private IServices<Categoria> categoriaServicio;

    @PostMapping("/create")
    public Categoria crear(Categoria nuevoRegistro) {
        return categoriaServicio.crear(nuevoRegistro);
    }

    @PutMapping("/update/{id}")
    public Categoria editar(Long id, Categoria nuevosDatos) {
        return categoriaServicio.actualizar(id, nuevosDatos);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(Long id) {
        categoriaServicio.eliminar(id);
    }

    @GetMapping("/find/{id}")
    public Categoria encontrar(Long id) {
        return categoriaServicio.encontrar(id);
    }

    @GetMapping("/find/all")
    public List<Categoria> listar() {
        return categoriaServicio.listar();
    }
}
