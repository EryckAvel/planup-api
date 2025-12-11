package com.eryckavel.planup.service;

import com.eryckavel.planup.model.Usuario;
import com.eryckavel.planup.repository.UsuarioRepository;
import com.eryckavel.planup.util.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class BaseService {

    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;

    public BaseService(JwtUtil jwtUtil, UsuarioRepository usuarioRepository) {
        this.jwtUtil = jwtUtil;
        this.usuarioRepository = usuarioRepository;
    }

    protected Usuario getUsuarioLogado() {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            jwtUtil.getIdUsuarioDoToken(bearerToken.replace("Bearer ",""));
            String emailUsuario = jwtUtil.getEmailDoToken(bearerToken.replace("Bearer ",""));
            return usuarioRepository.buscarPorEmail(emailUsuario).
                    orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado!"));
        }
        throw new RuntimeException("Token JWT não encontrado na requisição");
    }

}
