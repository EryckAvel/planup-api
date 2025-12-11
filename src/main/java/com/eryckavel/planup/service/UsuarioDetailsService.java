package com.eryckavel.planup.service;

import com.eryckavel.planup.model.Usuario;
import com.eryckavel.planup.model.UsuarioDetails;
import com.eryckavel.planup.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository repository;

    public UsuarioDetailsService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repository.buscarPorEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email de Usuario não encontrado!"));
        return new UsuarioDetails(usuario);
    }

}
