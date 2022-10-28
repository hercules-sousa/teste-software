import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        System.out.println(sistema.classificaTriangulo(60, 60, 60));
        System.out.println(sistema.ehTrianguloRetangulo(5, 4, 3));
        System.out.println(sistema.ehRetangulo(1, 1, 2, 2));
        System.out.println(sistema.ehRetangulo(1, 2, 3, 4));
        System.out.println(sistema.ehRetangulo(4, 4, 4, 4));
        System.out.println(sistema.perimetroRetangulo(2.5, 3, 3, 2.5));
        System.out.println(sistema.areaPerimetro(-8.33));

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a expressão desejada (Ex.: 6 * 2): ");
        String operacao = sc.nextLine();
        System.out.printf("= %.2f \n", sistema.calculadora(operacao));

        sistema.cadastraUsuario("Hércules", "username@domain.com", "$0Password0");
    }
}
