import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    public static String mostrarMenu(ArrayList<String> opcoes) {
        System.out.println("Olá, pessoal. Qual das nossas funcionalidades você gostaria de utilizar?");

        StringBuilder menu = new StringBuilder("   \n");
        for(int i = 1; i <= opcoes.size(); i++) {
            menu.append(String.format("   %d. %s\n", i, opcoes.get(i - 1)));
        }

        System.out.println(menu);
        System.out.println("Escolha alguma das opções acima:");

        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();
        while (true) {
            try {
                int intOpcao = Integer.parseInt(opcao);
                if (intOpcao > 0 && intOpcao <= opcoes.size()) {
                    break;
                }
                else {
                    System.out.println();
                    System.out.println("Opção inválida");
                    System.out.println(menu);
                    System.out.println("Escolha alguma das opções acima:");
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Opção inválida");
                System.out.println(menu);
                System.out.println("Escolha alguma das opções acima:");
            }

            scanner = new Scanner(System.in);
            opcao = scanner.nextLine();
        }

        return opcao;
    }

    public static String mostrarMenuSimOuNao() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Você deseja tentar novamente o cadastro?");
        System.out.println("""
                                  \s
                                   1. Sim
                                   2. Não
                                """);
        String resposta = scanner.nextLine();
        while (!resposta.equals("1") && !resposta.equals("2")) {
            System.out.println();
            System.out.println("Por favor, digite uma entrada válida");
            System.out.println();
            System.out.println("Você deseja tentar novamente o cadastro?");
            System.out.println("""
                                  \s
                                   1. Sim
                                   2. Não
                                """);
            resposta = scanner.nextLine();
        }
        return resposta;
    }
}
