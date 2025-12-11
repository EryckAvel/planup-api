package com.eryckavel.planup.controller;

import com.eryckavel.planup.dto.response.query.MontanteHistoricoResponseQueryDTO;
import com.eryckavel.planup.service.MontanteHistoricoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/montante/historico")
@Tag(name = "Historico de Montante")
public class MontanteHistoricoController {

    private final MontanteHistoricoService service;

    public MontanteHistoricoController(MontanteHistoricoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MontanteHistoricoResponseQueryDTO>> listarHistoricoDeMontante(){
        return ResponseEntity.ok(service.listarMontanteHistorico());
    }

}
