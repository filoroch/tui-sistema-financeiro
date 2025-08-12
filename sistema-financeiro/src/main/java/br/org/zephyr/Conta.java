package br.org.zephyr;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private final List<Transacao> transacoes;

    public Conta() {
        this.transacoes = new ArrayList();
    }
    /** Lista todas as transações disponiveis
    */
    public void listarTransacoes()
    {
        if (transacoes != null || transacoes.isEmpty())
        transacoes.forEach(
            t -> System.out.println(t)
        );
        else {
            System.err.println("");
        };
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
    public void editarTransacao(int _id, String _novaDescricao, TipoTransacao _novoTipoTransacao)
    {
        Transacao _novaTransação = transacoes.get(_id);
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
}
