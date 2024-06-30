package com.principal.aplicacionrecetas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.aplicacionrecetas.entities.Categoria;
import com.principal.aplicacionrecetas.repositories.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class CategoriaService implements IServices<Categoria> {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public Categoria encontrar(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria actualizar(Long id, Categoria nuevosDatos) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        if (nuevosDatos.getNombre() != null) {
            categoria.setNombre(nuevosDatos.getNombre());
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria crear(Categoria nuevoRegistro) {
        return categoriaRepository.save(nuevoRegistro);
    }

    @Override
    public void eliminar(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        categoriaRepository.delete(categoria);
    }
}
