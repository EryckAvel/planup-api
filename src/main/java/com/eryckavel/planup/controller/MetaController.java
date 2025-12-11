package com.eryckavel.planup.controller;

import com.eryckavel.planup.dto.request.custom.AtualizarMetaRequestDTO;
import com.eryckavel.planup.dto.request.custom.CadastrarMetaRequestDTO;
import com.eryckavel.planup.dto.response.model.MetaResponseDTO;
import com.eryckavel.planup.service.MetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meta")
public class MetaController {

    private final MetaService service;

    public MetaController(MetaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MetaResponseDTO>> listarMetasPorUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarMeta(@RequestBody @Validated CadastrarMetaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarMeta(dto));
    }

    @PutMapping("/{idMeta}")
    public ResponseEntity<String> atualizarMeta(@PathVariable("idMeta") Long idMeta, @RequestBody AtualizarMetaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(idMeta, dto));
    }

}
