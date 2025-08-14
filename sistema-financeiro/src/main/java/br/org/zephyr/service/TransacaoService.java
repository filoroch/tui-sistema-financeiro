package br.org.zephyr.service;

import java.util.ArrayList;
import java.util.List;
import br.org.zephyr.model.TipoTransacao;
import br.org.zephyr.model.Transacao;

/**
 * O papel dessa classe é fornecer uma forma de acessar um modelo de forma segura.
 * Os srvices encapsulam a logca basica de CREATE, READ, UPDATE E DELETE */ 
public class TransacaoService {
    private final List<Transacao> transacoes;

    public TransacaoService() {
        this.transacoes = new ArrayList();
    }

    public Transacao criarTransacao(String _descricao, Double _valor, TipoTransacao _tipoTransacao)
    {
        Transacao novaTransacao = new Transacao(_descricao, _valor, _tipoTransacao);
        transacoes.add(novaTransacao);
        return novaTransacao;
    }
    
    // Lista todas as transações disponiveis
    public List<Transacao> listarTransacoes()
    {
        return transacoes;
    }

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
    public Transacao bucarTransacao (int _id)
    {
        Transacao transacaoBuscada = transacoes.stream()
                                                .filter(t -> t.getId() == _id)
                                                .findFirst()
                                                .orElse(null);
        return transacaoBuscada;
    }
}
