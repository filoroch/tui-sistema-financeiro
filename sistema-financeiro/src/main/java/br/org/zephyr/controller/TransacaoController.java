package br.org.zephyr.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.org.zephyr.model.TipoTransacao;
import br.org.zephyr.model.Transacao;
import br.org.zephyr.service.TransacaoService;

/** 
 * Essa é uma classe de apresentação
 * Ela não encapsula logica, somente valida requisição e respostas 
 * os metodos tem que considerar formatação e apresentação de dados somente
 * Vai sermpre acessar o service
*/
public class TransacaoController {
    private final TransacaoService service = new TransacaoService();
    // TODAS AS TRANSACOES
    public void listarTransacoes()
    {
        service.listarTransacoes().forEach(t -> {
            System.out.println(t.toString());
        });;
    };
    // TRANSAÇOES DE UMA DATA ESPECIFICA
    public void listarTransacoes(LocalDate _data)
    {
        List<Transacao> filtradas = service.listarTransacoes();
        filtradas.stream().filter(t -> t.getCreatedAt().equals(_data)).collect(Collectors.toList());

        if (filtradas.isEmpty()){
            System.err.println("Não existem transações no escopo especificado " + _data.toString());
        } else {
            filtradas.forEach(t -> System.out.println(t));
        }
    };

    public void listarTransacoes(LocalDate _dataInicial, LocalDate _dataFinal)
    {
        List<Transacao> transacoes = service.listarTransacoes();
        List<Transacao> rangeInicial = transacoes.stream().filter(t -> t.getCreatedAt().isAfter(_dataFinal)).collect(Collectors.toList());
        List<Transacao> rangeFinal = rangeInicial.stream().filter(t -> t.getCreatedAt().isBefore(_dataInicial)).collect(Collectors.toList());

        if (rangeFinal.isEmpty()){
            System.err.println("Não existem transações no escopo especificado ");
        } else {
            rangeFinal.forEach(t -> System.out.println(t));
        }
    };

    // PEGA TRANSAÇÔES PELA DESCRIÇÂO
    public void listarTransacoes(String _descricao)
    {
        List<Transacao> filtradas = service.listarTransacoes();
        filtradas.stream()
                .filter(t -> t.getDescricao().equalsIgnoreCase(_descricao))
                .forEach(t -> System.out.println(t));
    };

    public void criarTransacao(String _descricao, Double _valor, int _tipoTransacao)
    {
        TipoTransacao tipoTransacao = null;

        if (_tipoTransacao == 1){ 
            tipoTransacao = tipoTransacao.ENTRADA;
        } 
        if (_tipoTransacao == 2){
            tipoTransacao = tipoTransacao.SAIDA;
        }
        if (_tipoTransacao == 3) {
            tipoTransacao = tipoTransacao.INVESTIMENTO;
        }
        Transacao novaTransacao = service.criarTransacao(_descricao, _valor, tipoTransacao);

        novaTransacao.toString();
    };
    // Sobrecarga
    public void editarTransacao(int _id, String _descricaoAtualizada){
        Transacao transcaoParaAtualizar = service.bucarTransacao(_id);
        transcaoParaAtualizar.setDescricao(_descricaoAtualizada);
    };
    public void editarTransacao(int _id, String _descricaoAtualizada, Double _valorAtualizado)
    {
        Transacao transcaoParaAtualizar = service.bucarTransacao(_id);
        transcaoParaAtualizar.setDescricao(_descricaoAtualizada);
        transcaoParaAtualizar.setValor(_valorAtualizado);
    };
    public void editarTransacao(int _id, String _descricaoAtualizada, Double _valorAtualizado, int _tipoTransacaoIndice)
    {
        Transacao transcaoParaAtualizar = service.bucarTransacao(_id);
        TipoTransacao tipoTransacaoAtualizado = null;

        if (_tipoTransacaoIndice == 1){  tipoTransacaoAtualizado = TipoTransacao.ENTRADA; }
        if (_tipoTransacaoIndice == 2){  tipoTransacaoAtualizado = TipoTransacao.SAIDA; }
        if (_tipoTransacaoIndice == 3){  tipoTransacaoAtualizado = TipoTransacao.INVESTIMENTO; }

        if (_tipoTransacaoIndice <= 0 || _tipoTransacaoIndice > 4){
            tipoTransacaoAtualizado = transcaoParaAtualizar.getTipoTransacao();
        }

        transcaoParaAtualizar.setDescricao(_descricaoAtualizada);
        transcaoParaAtualizar.setValor(_valorAtualizado);
        transcaoParaAtualizar.setTipoTransacao(tipoTransacaoAtualizado);
    };
    public void editarTransacao(int _id, Double _valorAtualizado){};
    public void editarTransacao(int _id, int _tipoTransacaoAtualizado){};

    public void excluirTransacao(int _id)
    {
        service.excluirTransacao(_id);
    };
    
    // POR ID
    public void buscarTransacao(int _idTransacao)
    {
        Transacao resultado = service.bucarTransacao(_idTransacao);
        
        if (resultado == null) {
            System.out.println("Não existe uma transação com esse ID");
        } else {
            System.out.println("O resultado da busca por " + _idTransacao + "é:");
            resultado.toString();
        }
    };
    // POR DESCRICAO
    public void buscarTransacao(String _descricaoTransacao)
    {
        Optional<Transacao> resultadoTransaçao =  service.listarTransacoes().stream().filter(t -> t.getDescricao().equalsIgnoreCase(_descricaoTransacao)).findFirst();
        
        resultadoTransaçao.get().toString();
    };
    // POR DATA
    public void buscarTransacao(LocalDate _dataTransacao)
    {
        Optional<Transacao> resultadoTransaçao =  service.listarTransacoes().stream().filter(t -> t.getCreatedAt().equals(_dataTransacao)).findFirst();

        resultadoTransaçao.get().toString();
    };

}
