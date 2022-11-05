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
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("O valor digitado não corresponde a nenhuma opção no menu acima.");
            }

            System.out.println(menu);
            System.out.println();
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
        System.out.println(mensagem);
        System.out.println();
        String resposta = mostrarMenuSimOuNao();
        return !resposta.equals("1");
    }
}
