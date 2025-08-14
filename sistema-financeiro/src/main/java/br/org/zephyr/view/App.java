package br.org.zephyr.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

import br.org.zephyr.model.TipoTransacao;
import br.org.zephyr.model.Transacao;
import br.org.zephyr.controller.TransacaoController;
import br.org.zephyr.service.TransacaoService;

public class App 
{
    public static void main( String[] args )
    {
        boolean isActive = true;
        int userMenu = 0;
        TransacaoController controller = new TransacaoController();
        Scanner scanner = new Scanner(System.in);
        controller.criarTransacao("Pastel", 11.50, 2 );

        do {
            try {
                switch (userMenu) {
                    case 0:
                        System.out.println("\nSISTEMA FINANCEIRO \nEscolha a opção desejada: \n1. Visualizar transações\n2. Adicionar uma nova transação\n3. Editar uma transação\n");
                        userMenu = scanner.nextInt();
                        break;
                    case 1:
                        System.out.println("\n-> 1. Visualizar transações\n");
                        controller.listarTransacoes();

                        System.out.println("\nVoltando ao menu");
                        userMenu = 0;
                        break;
                    case 2:
                        System.out.println("\n-> 2. Adicionar uma nova transação");
                        System.out.println("A transação é uma entrada, ou saida?\nDigite 1. Entrada ou 2. Saida");
                        int _tipoTransacao = scanner.nextInt();

                        System.out.println("\nDigite a descrição da transação");
                        String _descricaoTransacao = scanner.next();

                        System.out.println("\nDigite o valor da transação");
                        Double _valorTransacao = scanner.nextDouble();

                        controller.criarTransacao(_descricaoTransacao, _valorTransacao, _tipoTransacao);

                        System.out.println("\nDeseja voltar ao menu inicial? \n1. Sim\n2. Não");
                        userMenu = scanner.nextInt();
                        userMenu = userMenu == 2 ? 4 : 0;

                        break;
                    case 3:
                        // TODO: Corrigir o bug de não atualizar a descrição;
                        System.out.println("\n-> 3. Editar uma transação");
                        System.out.println("\tDigite o ID da transação\n");
                        int indice = scanner.nextInt();
                        scanner.nextLine();

                        controller.buscarTransacao(indice);

                        System.out.println("\tDigite nos campos que deseja editar abaixo ou deixe em branco oque deseja manter");
                        System.out.println("Digite a nova descrição\n");
                        String novaDescricao = scanner.nextLine();

                        System.out.println("Digite o novo valor");
                        Double novoValor = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("\t\tDigite o novo tipo de transferencia");
                        int novoTipoTranserencia = scanner.nextInt();
                        scanner.nextLine();

                        controller.editarTransacao(indice, novaDescricao, novoValor, novoTipoTranserencia);
                        controller.buscarTransacao(indice);

                        System.out.println("\nDeseja voltar ao menu inicial? \n1. Sim\n2. Não");
                        userMenu = scanner.nextInt();
                        userMenu = userMenu == 2 ? 4 : 0;
                        break;
                    default:
                        System.out.println("Saindo...........");
                        isActive = false;
                        break;
                }
            } catch (Exception e) {
                throw new InputMismatchException("Scanner esta recebenod algum valor errado. olha ai" + e);
            }
        } while (isActive != false);{}
    }
}