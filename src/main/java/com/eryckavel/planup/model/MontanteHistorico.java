package com.eryckavel.planup.model;

import com.eryckavel.planup.model.enums.TipoMovimentoHistorico;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "montante_historico")
public class MontanteHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_montante_historico")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_montante")
    private Montante montante;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimento")
    private TipoMovimentoHistorico tipoMovimento;
    @Column(name = "valor_anterior")
    private Double valorAnterior;
    @Column(name = "valor_diferenca")
    private Double valorDiferenca;
    @Column(name = "valor_atual")
    private Double valorAtual;
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    public MontanteHistorico() {
    }

    public MontanteHistorico(Long id, Montante montante, TipoMovimentoHistorico tipoMovimento, Double valorAnterior, Double valorDiferenca, Double valorAtual, LocalDateTime dataCriacao) {
        this.id = id;
        this.montante = montante;
        this.tipoMovimento = tipoMovimento;
        this.valorAnterior = valorAnterior;
        this.valorDiferenca = valorDiferenca;
        this.valorAtual = valorAtual;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Montante getMontante() {
        return montante;
    }

    public void setMontante(Montante montante) {
        this.montante = montante;
    }

    public TipoMovimentoHistorico getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimentoHistorico tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Double getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(Double valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public Double getValorDiferenca() {
        return valorDiferenca;
    }

    public void setValorDiferenca(Double valorDiferenca) {
        this.valorDiferenca = valorDiferenca;
    }

    public Double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
