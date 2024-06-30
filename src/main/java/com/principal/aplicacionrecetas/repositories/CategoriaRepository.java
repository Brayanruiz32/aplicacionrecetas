package com.principal.aplicacionrecetas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.principal.aplicacionrecetas.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
