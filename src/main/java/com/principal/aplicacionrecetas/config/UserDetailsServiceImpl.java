package com.principal.aplicacionrecetas.config;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.principal.aplicacionrecetas.entities.Usuario;
import com.principal.aplicacionrecetas.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsuario(username).orElseThrow(() -> new EntityNotFoundException());

        Collection<? extends GrantedAuthority> rol = Arrays.asList(new SimpleGrantedAuthority("ROLE_".concat(usuario.getRol().getNombre())));

        UserDetails userDetails = new User(username, usuario.getContrasenia(), rol);
        
        return userDetails;
    }


}
