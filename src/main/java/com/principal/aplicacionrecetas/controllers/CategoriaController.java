package com.principal.aplicacionrecetas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Categoria> crear(Categoria nuevoRegistro) {
        return ResponseEntity.ok(categoriaServicio.crear(nuevoRegistro));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Categoria> editar(Long id, Categoria nuevosDatos) {
        return ResponseEntity.ok(categoriaServicio.actualizar(id, nuevosDatos));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminar(Long id) {
        categoriaServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Categoria> encontrar(Long id) {
        return ResponseEntity.ok(categoriaServicio.encontrar(id));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(categoriaServicio.listar());
    }
}
