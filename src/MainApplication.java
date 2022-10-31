import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        Interface.showMenu();
        String entrada = scanner.nextLine();

        System.out.println(sistema.classificaTriangulo(60, 60, 60));

        System.out.println(sistema.ehTrianguloRetangulo(5, 4, 3));

        System.out.println(sistema.ehRetangulo(1, 1, 2, 2));
        System.out.println(sistema.ehRetangulo(1, 2, 3, 4));
        System.out.println(sistema.ehRetangulo(4, 4, 4, 4));
        System.out.println(sistema.ehRetangulo(-1, 4, -1, 4));

        System.out.println(sistema.perimetroRetangulo(2.5, 3, 3, 2.5));

        System.out.println(sistema.areaPerimetro(-8.33));

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a expressão desejada (Ex.: 6 * 2): ");
        String operacao = sc.nextLine();
        System.out.printf("= %.2f \n", sistema.calculadora(operacao));

        Usuario usuario = sistema.cadastraUsuario("Hércules", "username@domain.com", "$0Password0");
        System.out.println(usuario);

        Raizes raizes = sistema.calculaFuncaoSegundoGrau(2, 5, 2);
        System.out.println(raizes);

        Raizes raizes1 = sistema.calculaFuncaoSegundoGrau(2, 3, 2);
        System.out.println(raizes1);
    }
}
