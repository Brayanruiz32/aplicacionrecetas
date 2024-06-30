package com.principal.aplicacionrecetas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.aplicacionrecetas.entities.Rol;
import com.principal.aplicacionrecetas.repositories.RolRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RolService implements IServices<Rol> {

    @Autowired
    private RolRepository rolRepository;

    public Rol actualizar(Long id, Rol nuevosDatos) {
        Rol rol = rolRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        if (nuevosDatos.getNombre()!= null) {
            rol.setNombre(nuevosDatos.getNombre());
        }
        return rolRepository.save(rol);
    }

    public Rol crear(Rol nuevoRegistro) {
        
        return rolRepository.save(nuevoRegistro);
    }

    public void eliminar(Long id) {
        Rol rol = rolRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        rolRepository.delete(rol);        
    }

    public Rol encontrar(Long id) {
        return rolRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    

}
