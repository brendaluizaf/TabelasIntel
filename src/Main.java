import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Cadastrar produtos");
        System.out.println("2 - Consultar produtos");
        int escolha1 = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        switch (escolha1) {
            case 1:
                System.out.println("Escolha um produto para cadastrar:");
                System.out.println("1. Computadores");
                System.out.println("2. Processador");
                System.out.println("3. Sistema Operacional");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (escolha) {
                    case 1:
                        System.out.print("Digite o nome do computador: ");
                        String nomeComputadores = scanner.nextLine();

                        System.out.print("Digite o descricao do computador: ");
                        String descricaoComputadores = scanner.nextLine();

                        System.out.print("Digite o tipo do computador: ");
                        String tipoComputadores = scanner.nextLine();

                        System.out.println("Digite o mouse:");
                        String mouseComputadores = scanner.nextLine();

                        System.out.println("Digite o monitor:");
                        String monitorComputadores = scanner.nextLine();

                        Computadores computador = new Computadores(nomeComputadores, descricaoComputadores,
                                tipoComputadores,
                                mouseComputadores, monitorComputadores);
                        computador.exibirInfo();
                        BancoDeDados.inserirComputadores(computador);
                        break;

                    case 2:
                        System.out.print("Digite o nome do processador: ");
                        String nomeProcessador = scanner.nextLine();

                        System.out.print("Digite a descricao do processador: ");
                        String descricaoProcessador = scanner.nextLine();

                        System.out.print("Digite o tipo do processador: ");
                        String tipoProcessador = scanner.nextLine();

                        System.out.print("Digite a quantidade de cores do processador: ");
                        String coreProcessador = scanner.nextLine();

                        System.out.print("Digite a frequência do processador: ");
                        String frequenciaProcessador = scanner.nextLine();

                        Processador novoProcessador = new Processador(nomeProcessador, descricaoProcessador,
                                tipoProcessador,
                                coreProcessador, frequenciaProcessador);
                        novoProcessador.exibirInfo();
                        BancoDeDados.InserirProcessador(novoProcessador);
                        break;

                    case 3:
                        System.out.print("Digite o nome do Sistema Operacional: ");
                        String nomeSistemaOperacional = scanner.nextLine();

                        System.out.print("Digite a descrição do Sistema Operacional: ");
                        String descricaoSistemaOperacional = scanner.nextLine();

                        System.out.print("Digite o tipo desse Sistema Operacional: ");
                        String tipoSistemaOperacional = scanner.nextLine();

                        System.out.println("Digite o fabricante:");
                        String fabricanteSistemaOperacional = scanner.nextLine();

                        System.out.println("Digite o ano de lançamento:");
                        String anoSistemaOperacional = scanner.nextLine();

                        SistemaOperacional novoSistemaOperacional = new SistemaOperacional(nomeSistemaOperacional,
                                descricaoSistemaOperacional, tipoSistemaOperacional, fabricanteSistemaOperacional,
                                anoSistemaOperacional);
                        novoSistemaOperacional.exibirInfo();
                        BancoDeDados.inserirSistema(novoSistemaOperacional);
                        // BancoDeDados.inserirSistemas(novoSistemaOperacional);
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                scanner.close();

            case 2:
                System.out.println("Escolha um produto para consultar:");
                System.out.println("1. Computadores");
                System.out.println("2. Processador");
                System.out.println("3. Sistema Operacional");
                int escolha2 = scanner.nextInt();
                scanner.nextLine();
                switch (escolha2) {
                    case 1:
                        BancoDeDados.ConsultaComputador();
                    case 2:
                        BancoDeDados.ConsultaProcessador();

                    case 3:
                        BancoDeDados.ConsultaSistema();

                }

        }
    }
}
