package com.principal.aplicacionrecetas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.principal.aplicacionrecetas.entities.Comida;
import com.principal.aplicacionrecetas.entities.Tipo;

public interface ComidaRepository extends JpaRepository<Comida, Long> {

    List<Comida> findByTipo(Tipo tipo);

    @Query("SELECT co FROM Comida co JOIN co.categoria ca WHERE ca.nombre=:categoria")
    List<Comida> encontrarPorNombreCategoria(String categoria);



    
} 
