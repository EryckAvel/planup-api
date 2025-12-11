package com.eryckavel.planup.dto.request.custom;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CadastrarMetaRequestDTO {

    @NotBlank
    private String nomeMeta;
    @NotNull
    private Double valorEstimado;

    public CadastrarMetaRequestDTO() {
    }

    public CadastrarMetaRequestDTO(String nomeMeta, Double valorEstimado) {
        this.nomeMeta = nomeMeta;
        this.valorEstimado = valorEstimado;
    }

    public String getNomeMeta() {
        return nomeMeta;
    }

    public void setNomeMeta(String nomeMeta) {
        this.nomeMeta = nomeMeta;
    }

    public Double getValorEstimado() {
        return valorEstimado;
    }

}
