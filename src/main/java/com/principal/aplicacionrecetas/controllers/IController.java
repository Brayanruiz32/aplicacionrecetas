package com.principal.aplicacionrecetas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IController<T> {

    List<T> listar();

    T encontrar(@PathVariable Long id);

    T crear(@RequestBody T nuevoRegistro);

    T editar(@PathVariable Long id, @RequestBody T nuevosDatos);

    void eliminar(@PathVariable Long id);

}
