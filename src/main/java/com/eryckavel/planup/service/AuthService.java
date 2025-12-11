package com.eryckavel.planup.service;

import com.eryckavel.planup.dto.request.custom.CadastrarUsuarioResponseDTO;
import com.eryckavel.planup.dto.request.custom.LoginRequestDTO;
import com.eryckavel.planup.dto.response.custom.LoginResponseDTO;
import com.eryckavel.planup.exception.exceptions.LoginException;
import com.eryckavel.planup.model.Usuario;
import com.eryckavel.planup.repository.UsuarioRepository;
import com.eryckavel.planup.util.JwtUtil;
import jakarta.persistence.EntityExistsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository repository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UsuarioRepository repository, JwtUtil jwtUtil, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public String cadastrar(CadastrarUsuarioResponseDTO dto){
        if (repository.buscarPorEmail(dto.getEmail()).isPresent()) throw new EntityExistsException("Email já Cadastrado!");
        Usuario usuario = new Usuario();
        converterUsuario(usuario, dto);
        repository.save(usuario);
        return "Cadastro Finalizado com Sucesso!";
    }

    public LoginResponseDTO login(LoginRequestDTO dto){
        Usuario usuario = repository.buscarPorEmail(dto.getEmail())
                .orElseThrow(() -> new LoginException("Login ou Senha Incorreto!"));
        if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
            throw new LoginException("Senha esta incorreta!");
        }
        String token = jwtUtil.gerarToken(dto.getEmail(), usuario.getId());
        return new LoginResponseDTO(token);
    }

    private void converterUsuario(Usuario usuario, CadastrarUsuarioResponseDTO dto) {
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setAtivo(true);
    }

}
