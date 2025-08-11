package br.org.zephyr;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // TODO: Criar um menu iterativo, tirar a responsabilidade de instanciar as classes manualmente
        Transacao t1 = new Transacao("PS5", 1500.0, TipoTransacao.SAIDA);
        Transacao t2 = new Transacao("Salario mensal", 6500.0, TipoTransacao.ENTRADA);
        Transacao t3 = new Transacao("Rendimento X", 250.0, TipoTransacao.INVESTIMENTO);

        TransacaoDAO builder = new TransacaoDAO();
        builder.adicionarTransacao(t1);
        builder.adicionarTransacao(t2);
        builder.adicionarTransacao(t3);

        builder.listarTransacoes();
    }
}
