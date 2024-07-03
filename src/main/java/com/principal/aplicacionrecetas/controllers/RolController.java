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

import com.principal.aplicacionrecetas.entities.Rol;
import com.principal.aplicacionrecetas.services.IServices;

@RestController
@RequestMapping("/rol")
public class RolController implements IController<Rol>{

    @Autowired
    private IServices<Rol> rolService;

    @PostMapping("/create")
    public ResponseEntity<Rol> crear(Rol nuevoRegistro) {
        return ResponseEntity.ok(rolService.crear(nuevoRegistro));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Rol> editar(Long id, Rol nuevosDatos) {
        return ResponseEntity.ok(rolService.actualizar(id, nuevosDatos));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminar(Long id) {
        rolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Rol> encontrar(Long id) {
        return ResponseEntity.ok(rolService.encontrar(id));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Rol>> listar() {
        return ResponseEntity.ok(rolService.listar());
    }








}
