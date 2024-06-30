package com.principal.aplicacionrecetas.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.principal.aplicacionrecetas.entities.Comida;
import com.principal.aplicacionrecetas.services.ComidaService;

@RestController
@RequestMapping("/comida")
public class ComidaController{

    @Autowired
    private ComidaService comidaServicio;

    @PostMapping("/create")
    public Comida crear(@RequestPart Comida nuevoRegistro, @RequestPart("imagen") MultipartFile imagen ) throws SerialException, SQLException {
        return comidaServicio.crear(nuevoRegistro, imagen);
    }

    @PutMapping("/update/{id}")
    public Comida editar(@PathVariable Long id, @RequestBody Comida nuevosDatos) {
        return comidaServicio.actualizar(id, nuevosDatos);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable Long id) {
        comidaServicio.eliminar(id);
    }

    @GetMapping("/find/{id}")
    public Comida encontrar(@PathVariable Long id) {
        return comidaServicio.encontrar(id);
    }

    @GetMapping("/find/all")
    public List<Comida> listar() {
        return comidaServicio.listar();
    }


}
