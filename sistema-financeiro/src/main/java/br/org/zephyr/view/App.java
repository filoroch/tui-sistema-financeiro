package br.org.zephyr.view;

import java.util.Scanner;
import br.org.zephyr.ShellApplication;
import br.org.zephyr.controller.TransacaoDAO;
import br.org.zephyr.model.TipoTransacao;
import br.org.zephyr.model.Transacao;

public class App 
{
    public static void main( String[] args )
    {
        boolean isActive = true;
        TransacaoDAO controller = new TransacaoDAO();
        int userMenu = 0;
        ShellApplication app = new ShellApplication();

        do {
            try (Scanner scanner = new Scanner(System.in)) {
                // TODO: Criar um menu iterativo, tirar a responsabilidade de instanciar as classes manualmente
                switch (userMenu) {
                    case 0:
                        app.menu();
                        userMenu = scanner.nextInt();
                    case 1:
                        System.out.println("\n1. Visualizar transações\n");
                        controller.listarTransacoes();

                        System.out.println("\nDeseja voltar ao menu inicial? \n1. Sim\n2. Não");                                                     
                        userMenu = scanner.nextInt(); 

                    case 2:
                        System.out.println("\n2. Adicionar uma nova transação");
                        System.out.println("A transação é uma entrada, ou saida?\nDigite 1. Entrada ou 2. Saida\n");
                        int refTransacao = scanner.nextInt();
                        TipoTransacao _tipoTransacao = null;

                        if (refTransacao == 1) {
                            _tipoTransacao = TipoTransacao.ENTRADA;
                        } else {
                            _tipoTransacao = TipoTransacao.SAIDA;
                        }

                        System.out.println("\nDigite a descrição da transação\n");
                        String _descricaoTransacao = scanner.next();

                        System.out.println("\nDigite o valor da transação\n");
                        Double _valorTransacao = scanner.nextDouble();

                        Transacao transacao = new Transacao(_descricaoTransacao, _valorTransacao, _tipoTransacao);
                        controller.adicionarTransacao(transacao);
                        transacao.toString();
                    case 3:
                        System.out.println("3. Editar uma transação");
                    default:
                        System.out.println("Saindo...........");
                        isActive = false;
                }
            }


            ;
        } while (isActive != false);{}
    }
}
