package com.eryckavel.planup.dto.response.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonPropertyOrder({"tipoMovimento", "valorDiferenca", "dataCriacao"})
public interface MontanteHistoricoResponseQueryDTO {

    @JsonProperty("tipoMovimento")
    String getTipo_movimento();
    @JsonProperty("valorDiferenca")
    Double getValor_diferenca();
    @JsonProperty("dataCriacao")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime getData_criacao();

}
