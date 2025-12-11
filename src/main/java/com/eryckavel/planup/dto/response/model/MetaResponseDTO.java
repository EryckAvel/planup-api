package com.eryckavel.planup.dto.response.model;

import com.eryckavel.planup.model.Meta;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class MetaResponseDTO {

    private Long id;
    private Long idUsuario;
    private String nomeMeta;
    private Double valorEstimado;
    private Double valorGasto;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataAtualizacao;

    public MetaResponseDTO() {
    }

    public MetaResponseDTO(Meta meta) {
        this.id = meta.getId();
        this.idUsuario = meta.getUsuario() != null ? meta.getUsuario().getId() : null;
        this.nomeMeta = meta.getNomeMeta();
        this.valorEstimado = meta.getValorEstimado();
        this.valorGasto = meta.getValorGasto();
        this.dataCriacao = meta.getDataCriacao();
        this.dataAtualizacao = meta.getDataAtualizacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
