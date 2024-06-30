package com.principal.aplicacionrecetas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.principal.aplicacionrecetas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsuario(String username);

    
} 