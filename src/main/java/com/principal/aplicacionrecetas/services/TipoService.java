package com.principal.aplicacionrecetas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.aplicacionrecetas.entities.Tipo;
import com.principal.aplicacionrecetas.repositories.TipoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoService implements IServices<Tipo> {

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public Tipo encontrar(Long id) {
        return tipoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public List<Tipo> listar() {
        return tipoRepository.findAll();
    }

    @Override
    public Tipo actualizar(Long id, Tipo nuevosDatos) {
        Tipo tipo = tipoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        if (nuevosDatos.getNombre() != null) {
            tipo.setNombre(nuevosDatos.getNombre());
        }

        return tipoRepository.save(tipo);
    }

    @Override
    public Tipo crear(Tipo nuevoRegistro) {
        return tipoRepository.save(nuevoRegistro);
    }

    @Override
    public void eliminar(Long id) {
        Tipo tipo = tipoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        tipoRepository.delete(tipo);
    }



    
    
    

}
