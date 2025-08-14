package controller;

import java.time.LocalDate;
import java.util.List;

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
    private final TransacaoService _Service = new TransacaoService();
    // TODAS AS TRANSACOES
    public void listarTransacoes()
    {
        _Service.listarTransacoes().forEach(t -> {
            System.out.println(t.toString());
        });;
    };
    // TRANSAÇOES DE UMA DATA ESPECIFICA
    public void listarTransacoes(LocalDate _data)
    {
        List<Transacao> filtradas = _Service.listarTransacoes();
        filtradas.stream()
                .filter(t -> t.getCreatedAt().equals(_data))
                .forEach(t -> System.out.println(t));
    };

    // TODO: Implementar a logica sobrescrita do listarTransações quando passo range de datas
    public void listarTransacoes(LocalDate _dataInicial, LocalDate _dataFinal)
    {

    };
    // PEGA TRANSAÇÔES PELA DESCRIÇÂO
    public void listarTransacoes(String _descricao)
    {
        List<Transacao> filtradas = _Service.listarTransacoes();
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
        Transacao novaTransacao = _Service.criarTransacao(_descricao, _valor, tipoTransacao);

        novaTransacao.toString();
    };
    // Sobrecarga
    public void editarTransacao(int _id, String _descricaoAtualizada){
        
    };
    public void editarTransacao(int _id, String _descricaoAtualizada, Double _valorAtualizado){};
    public void editarTransacao(int _id, String _descricaoAtualizada, Double _valorAtualizado, int _tipoTransacaoAtualizado){};
    public void editarTransacao(int _id, Double _valorAtualizado){};
    public void editarTransacao(int _id, int _tipoTransacaoAtualizado){};

    public void excluirTransacao(){};
    
    // POR ID
    public void buscarTransacao(int _idTransacao){};
    // POR DESCRICAO
    public void buscarTransacao(String _descricaoTransacao){};
    // POR DATA
    public void buscarTransacao(LocalDate _dataTransacao){};

}
