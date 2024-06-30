package com.principal.aplicacionrecetas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.principal.aplicacionrecetas.entities.Comida;

public interface ComidaRepository extends JpaRepository<Comida, Long> {

    
} 
