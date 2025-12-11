package com.eryckavel.planup.controller;

import com.eryckavel.planup.dto.request.custom.CadastrarUsuarioResponseDTO;
import com.eryckavel.planup.dto.request.custom.LoginRequestDTO;
import com.eryckavel.planup.dto.response.custom.LoginResponseDTO;
import com.eryckavel.planup.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody CadastrarUsuarioResponseDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.login(dto));
    }

}
