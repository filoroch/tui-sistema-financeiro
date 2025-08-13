package br.org.zephyr.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Representa uma transação do mundo real identificada por Id, tendo uma descrição, um valor, uma data de criação e um tipo de transação associado
 */ 
public class Transacao {
    private UUID id;
    private String descricao;
    private Double valor;
    private LocalDate createdAt;
    private TipoTransacao tipoTransacao;

    public Transacao(String _descricao, Double _valor, TipoTransacao _tipoTransacao) {
        if (_descricao == null || _valor == null || _tipoTransacao == null){
            throw new IllegalArgumentException("Os parametros descrição, valor e tpo de transação não podem ser nulos/vazioz");
        }
        if (_valor < 0){
            throw new IllegalArgumentException("O valor da transação não pode ser nulo");
        }

        this.id = UUID.randomUUID();
        this.descricao = _descricao;
        this.valor = _valor;
        this.createdAt = LocalDate.now();
        this.tipoTransacao = _tipoTransacao;
    }

    public UUID getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }
    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    @Override
    public String toString() {
        return "Transacao: " + id + " {"
                + "\n\tdescricao: " + descricao
                + "\n\tvalor: " + valor
                + "\n\tcreatedAt: " + createdAt
                + "\n\ttipoTransacao: " + tipoTransacao +
                "\n}";
    }
}
