package com.eryckavel.planup.dto.request.custom;

public class AtualizarMetaRequestDTO {

    private String nomeMeta;
    private Double valorEstimado;
    private Double valorGasto;

    public AtualizarMetaRequestDTO() {
    }

    public AtualizarMetaRequestDTO(String nomeMeta, Double valorEstimado, Double valorGasto) {
        this.nomeMeta = nomeMeta;
        this.valorEstimado = valorEstimado;
        this.valorGasto = valorGasto;
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

    public void setValorEstimado(Double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

    public Double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(Double valorGasto) {
        this.valorGasto = valorGasto;
    }

}
