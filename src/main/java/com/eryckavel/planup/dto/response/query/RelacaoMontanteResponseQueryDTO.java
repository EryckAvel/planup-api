package com.eryckavel.planup.dto.response.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"saldo", "totalEstimado", "totalGasto"})
public interface RelacaoMontanteResponseQueryDTO {

    Double getSaldo();
    @JsonProperty("totalEstimado")
    Double getTotal_estimado();
    @JsonProperty("totalGasto")
    Double getTotal_gasto();

}
