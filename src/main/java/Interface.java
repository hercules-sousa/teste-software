import com.diogonunes.jcolor.AnsiFormat;

import java.util.ArrayList;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class Interface {
    private static final AnsiFormat erroFormat = new AnsiFormat(RED_TEXT(), BOLD());
    private static final AnsiFormat sucessoFormato = new AnsiFormat(BRIGHT_GREEN_TEXT());
    private static final AnsiFormat avisoFormato = new AnsiFormat(BRIGHT_YELLOW_TEXT());
    private static final AnsiFormat opcaoMenuFormato = new AnsiFormat(ITALIC());

    public static String mostrarMenu(String cabecalho, ArrayList<String> opcoes) {
        System.out.println(cabecalho);

        StringBuilder menu = new StringBuilder("   \n");
        for(int i = 1; i <= opcoes.size(); i++) {
            menu.append(colorize(String.format("   %d. %s\n", i, opcoes.get(i - 1)), opcaoMenuFormato));
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
                printErro("\nO valor digitado não corresponde a nenhuma opção no menu acima.\n");
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

    private static void printColorido(String texto, AnsiFormat formato) {
        System.out.println(colorize(texto, formato));
    }

    public static void printSucesso(String mensagem) {
        printColorido(mensagem, sucessoFormato);
    }

    public static void printAviso(String mensagem) {
        printColorido(mensagem, avisoFormato);
    }

    public static void printErro(String mensagem) {
        printColorido(mensagem, erroFormat);
    }

    public static boolean lidarComErro(String mensagem) {
        System.out.println();
        printErro(mensagem);
        System.out.println();
        String resposta = mostrarMenuSimOuNao();
        System.out.println();
        return !resposta.equals("1");
    }
}
