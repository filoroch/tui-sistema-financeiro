package br.org.zephyr;

import java.time.LocalDate;
/**
 * Representa uma transação do mundo real identificada por Id, tendo uma descrição, um valor, uma data de criação e um tipo de transação associado
 */ 
public class Transacao {
    private static int id;
    private String descricao;
    private Double valor;
    private LocalDate createdAt;
    private TipoTransacao tipoTransacao;

    public Transacao(String _descricao, Double _valor, TipoTransacao _tipoTransacao) {
        this.id = id++;
        this.descricao = _descricao;
        this.valor = _valor;
        this.createdAt = LocalDate.now();
        this.tipoTransacao = _tipoTransacao;
    }

    public int getId() {
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
        return "Transacão Nº: " + id + "\tdescricao: " + descricao + "\tvalor: " + valor + "\tgerado em :" + createdAt
                + "\ttipo: " + tipoTransacao;
    }
    
}
