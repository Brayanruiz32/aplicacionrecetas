package com.principal.aplicacionrecetas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/find/{id}")
    public Usuario encontrar(Long id) {
        return usuarioService.encontrar(id);
    }

    @PostMapping("/create")
    public Usuario crear(Usuario nuevoRegistro) {
        return usuarioService.crear(nuevoRegistro);
    }

    @PutMapping("/update/{id}")
    public Usuario editar(Long id, Usuario nuevosDatos) {
        return usuarioService.actualizar(id, nuevosDatos);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(Long id) {
        usuarioService.eliminar(id);
    }
}
