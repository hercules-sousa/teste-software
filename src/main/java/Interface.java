import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    public static String mostrarMenu(String cabecalho, ArrayList<String> opcoes) {
        System.out.println(cabecalho);

        StringBuilder menu = new StringBuilder("   \n");
        for(int i = 1; i <= opcoes.size(); i++) {
            menu.append(String.format("   %d. %s\n", i, opcoes.get(i - 1)));
        }

        System.out.println(menu);
        String opcao = pedirEntrada("Escolha alguma das opções acima:");

        while (true) {
            try {
                int intOpcao = Integer.parseInt(opcao);
                if (intOpcao > 0 && intOpcao <= opcoes.size()) {
                    break;
                }
                else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\n\u001B[31mO valor digitado não corresponde a nenhuma opção no menu acima.\u001B[0m\n");
            }

            System.out.println(cabecalho);
            System.out.println(menu);
            opcao = pedirEntrada("Escolha alguma das opções acima:");
        }

        return opcao;
    }

    public static String mostrarMenuSimOuNao() {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Sim");
        opcoes.add("Não");
        return mostrarMenu("Você deseja tentar novamente a operação?", opcoes);
    }

    public static String pedirEntrada(String texto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(texto);
        return scanner.nextLine();
    }

    public static boolean lidarComErro(String mensagem) {
        System.out.println();
        System.out.println("\u001B[31m" + mensagem + "\u001B[0m");
        System.out.println();
        String resposta = mostrarMenuSimOuNao();
        System.out.println();
        return !resposta.equals("1");
    }
}
