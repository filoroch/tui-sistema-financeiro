package br.org.zephyr.view;

import java.util.Scanner;
import java.util.UUID;

import br.org.zephyr.controller.TransacaoController;
import br.org.zephyr.model.TipoTransacao;
import br.org.zephyr.model.Transacao;

public class App 
{
    public static void main( String[] args )
    {
        boolean isActive = true;
        int userMenu = 0;
        TransacaoController controller = new TransacaoController();
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                // TODO: Criar um menu iterativo, tirar a responsabilidade de instanciar as classes manualmente
                switch (userMenu) {
                    case 0:
                        System.out.println("\nSISTEMA FINANCEIRO \nEscolha a opção desejada: \n1. Visualizar transações\n2. Adicionar uma nova transação\n3. Editar uma transação\n");
                        userMenu = scanner.nextInt();
                        break;
                    case 1:
                        System.out.println("\n-> 1. Visualizar transações\n");
                        controller.listarTransacoes();

                        System.out.println("\nDeseja voltar ao menu inicial? \n1. Sim\n2. Não");
                        userMenu = scanner.nextInt();
                        break;
                    case 2:
                        System.out.println("\n-> 2. Adicionar uma nova transação");
                        System.out.println("A transação é uma entrada, ou saida?\nDigite 1. Entrada ou 2. Saida");
                        int refTransacao = scanner.nextInt();
                        TipoTransacao _tipoTransacao = null;

                        if (refTransacao == 1) {
                            _tipoTransacao = TipoTransacao.ENTRADA;
                        } else {
                            _tipoTransacao = TipoTransacao.SAIDA;
                        }

                        System.out.println("\nDigite a descrição da transação");
                        String _descricaoTransacao = scanner.next();

                        System.out.println("\nDigite o valor da transação");
                        Double _valorTransacao = scanner.nextDouble();

                        Transacao transacao = controller.criarTransacao(_descricaoTransacao, _valorTransacao, _tipoTransacao);

                        controller.adicionarTransacao(transacao);
                        System.out.println("\n" + transacao.toString());

                        System.out.println("\nDeseja voltar ao menu inicial? \n1. Sim\n2. Não");
                        userMenu = scanner.nextInt();
                        userMenu = userMenu == 2 ? 4 : 0;

                        break;
                    case 3:
                        System.out.println("\n-> 3. Editar uma transação");
                        System.out.println("\tDigite o UUID ou o indice da transação\n");
                        String indice = scanner.next();
                        UUID indiceT = UUID.fromString(indice);
                        Transacao updateTransacao = controller.bucarTransacao(indiceT);
                        updateTransacao.toString();
                        break;
                    default:
                        System.out.println("Saindo...........");
                        isActive = false;
                        break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } while (isActive != false);{}
    }
}
