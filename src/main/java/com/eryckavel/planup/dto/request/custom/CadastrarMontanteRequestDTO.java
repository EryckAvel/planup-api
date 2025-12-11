package com.eryckavel.planup.dto.request.custom;

import com.eryckavel.planup.model.enums.TipoMovimentoHistorico;
import jakarta.validation.constraints.NotNull;

public class CadastrarMontanteRequestDTO {

    @NotNull
    private Double valor;
    @NotNull
    private TipoMovimentoHistorico tipoMovimento;

    public CadastrarMontanteRequestDTO() {
    }

    public CadastrarMontanteRequestDTO(Double valor, TipoMovimentoHistorico tipoMovimento) {
        this.valor = valor;
        this.tipoMovimento = tipoMovimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoMovimentoHistorico getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimentoHistorico tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

}
