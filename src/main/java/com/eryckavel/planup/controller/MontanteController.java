package com.eryckavel.planup.controller;

import com.eryckavel.planup.dto.request.custom.CadastrarMontanteRequestDTO;
import com.eryckavel.planup.dto.response.query.RelacaoMontanteResponseQueryDTO;
import com.eryckavel.planup.service.MontanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/montante")
public class MontanteController {

    private MontanteService service;

    public MontanteController(MontanteService service) {
        this.service = service;
    }

    @GetMapping("/relacao")
    public ResponseEntity<RelacaoMontanteResponseQueryDTO> consultarRelacaoMontante(){
        return ResponseEntity.ok(service.consultarRelacaoMontate());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarMontante(@RequestBody @Validated CadastrarMontanteRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarMontante(dto));
    }

}
