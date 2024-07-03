package com.principal.aplicacionrecetas.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IController<T> {

    ResponseEntity<List<T>> listar();

    ResponseEntity<T> encontrar(@PathVariable Long id);

    ResponseEntity<T> crear(@RequestBody T nuevoRegistro);

    ResponseEntity<T> editar(@PathVariable Long id, @RequestBody T nuevosDatos);

    ResponseEntity<Void> eliminar(@PathVariable Long id);

}
