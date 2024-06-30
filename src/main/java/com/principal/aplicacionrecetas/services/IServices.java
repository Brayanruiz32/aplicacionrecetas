package com.principal.aplicacionrecetas.services;

import java.util.List;

public interface IServices<T> {

    List<T> listar();

    T encontrar(Long id);

    T crear(T nuevoRegistro);

    T actualizar(Long id, T nuevosDatos);

    void eliminar(Long id);

}
