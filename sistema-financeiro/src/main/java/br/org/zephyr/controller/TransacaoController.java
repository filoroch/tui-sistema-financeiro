package br.org.zephyr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.org.zephyr.model.TipoTransacao;
import br.org.zephyr.model.Transacao;

public class TransacaoController {
    private final List<Transacao> transacoes;

    public TransacaoController() {
        this.transacoes = new ArrayList();
    }
    // _tipoTransacao precisa ser validado na view
    public Transacao criarTransacao(String _descricao, Double _valor, TipoTransacao _tipoTransacao)
    {
        //TipoTransacao novoTipoTransacao;
        //novoTipoTransacao = _tipoTransacao == 1 ? TipoTransacao.ENTRADA : TipoTransacao.SAIDA;

        Transacao novaTransacao;
        return novaTransacao = new Transacao(_descricao, _valor, _tipoTransacao);
    }
    /** Lista todas as transações disponiveis
    */
    public void listarTransacoes()
    {
        transacoes.forEach(
            t -> System.out.println(t)
        );
    }

    /** 
     * Recebe uma transação e adiciona ao final da lista de transações
     * @param _transacao que representa um objeto concreto de uma transação
    */
    public void adicionarTransacao(Transacao _transacao)
    {
        transacoes.add(_transacao);
    }


    /** Recebe um Id, uma descrição e um tipo de transação e modifica o objeto Transação original
     * @param _id usado para achar a Transação
     * @param _novaDescricao opcional. Se vazio, vai ser permitido o valor original, se não, passado o valor da referencia
     * @param _novoTipoTransacao opcional. Se vazio, vai ser permitido o valor original, se não, passado o valor da referencia
    */
    public void editarTransacao(UUID _id, String _novaDescricao, TipoTransacao _novoTipoTransacao)
    {
        Transacao _novaTransação = transacoes.stream().filter(t -> t.getId() == _id).findFirst().orElse(null);
        _novaDescricao = _novaDescricao.isEmpty() ? _novaTransação.getDescricao() : _novaDescricao;
        _novoTipoTransacao = _novoTipoTransacao.equals(_novaTransação.getTipoTransacao()) ? _novaTransação.getTipoTransacao() : _novoTipoTransacao;

        if (_novaTransação != null){
            _novaTransação.setDescricao(_novaDescricao);
            _novaTransação.setTipoTransacao(_novoTipoTransacao);
        }
    }
    public void excluirTransacao(int _id){
        transacoes.remove(_id);
    }
    public Transacao bucarTransacao (UUID _id)
    {
        Transacao transacaoBuscada = transacoes.stream()
                                                .filter(t -> t.getId().equals(_id))
                                                .findFirst()
                                                .orElse(null);
        return transacaoBuscada;
    }
}
