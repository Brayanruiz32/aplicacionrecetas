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

import com.principal.aplicacionrecetas.entities.Usuario;
import com.principal.aplicacionrecetas.services.IServices;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements IController<Usuario> {

    @Autowired
    private IServices<Usuario> usuarioService;

    @GetMapping("/find/all")
    public ResponseEntity<List<Usuario>> listar() {
        return  ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Usuario> encontrar(Long id) {
        return  ResponseEntity.ok(usuarioService.encontrar(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> crear(Usuario nuevoRegistro) {
        return  ResponseEntity.ok(usuarioService.crear(nuevoRegistro));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> editar(Long id, Usuario nuevosDatos) {
        return  ResponseEntity.ok(usuarioService.actualizar(id, nuevosDatos));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminar(Long id) {
        usuarioService.eliminar(id);
       return ResponseEntity.noContent().build();
    }
}
