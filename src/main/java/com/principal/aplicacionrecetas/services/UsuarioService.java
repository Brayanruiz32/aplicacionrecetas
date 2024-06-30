package com.principal.aplicacionrecetas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.principal.aplicacionrecetas.entities.Rol;
import com.principal.aplicacionrecetas.entities.Usuario;
import com.principal.aplicacionrecetas.repositories.RolRepository;
import com.principal.aplicacionrecetas.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService implements IServices<Usuario> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository ;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario actualizar(Long id, Usuario nuevosDatos) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());

        if (nuevosDatos.getUsuario() != null) {
            usuario.setUsuario(nuevosDatos.getUsuario());
        }
        if (nuevosDatos.getContrasenia() != null) {
            usuario.setContrasenia(passwordEncoder.encode(nuevosDatos.getContrasenia()));
        }

        if (nuevosDatos.getRol().getId() != null) {
            Rol rol = rolRepository.findById(nuevosDatos.getRol().getId()).orElseThrow(() -> new EntityNotFoundException());
            usuario.setRol(rol);
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario crear(Usuario nuevoRegistro) {
        Rol rol = rolRepository.findById(nuevoRegistro.getRol().getId()).orElseThrow(() -> new EntityNotFoundException());
        nuevoRegistro.setRol(rol);
        String contrasenia = passwordEncoder.encode(nuevoRegistro.getContrasenia());
        nuevoRegistro.setContrasenia(contrasenia);
        return usuarioRepository.save(nuevoRegistro);
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario encontrar(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe el usuario en la BD"));
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    



}
