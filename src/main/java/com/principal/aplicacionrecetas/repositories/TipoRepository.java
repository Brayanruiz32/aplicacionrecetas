package com.principal.aplicacionrecetas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.principal.aplicacionrecetas.entities.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

}
