import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        Interface.showMenu();
        String entrada = scanner.nextLine();


        while (!entrada.equals("11")) {
            // Código para limpar o console
            // Não funciona em uma IDE
            // System.out.print("\033[H\033[2J");
            // System.out.flush();

            System.out.println();

            switch (entrada) {
                case "1":
                    System.out.println("Vamos cadastrar um novo cliente.");
                    System.out.println("Para realizar essa operação vamos precisar de algumas informações.");
                    System.out.println("Digite o nome do usuário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o email do usuário:");
                    String email = scanner.nextLine();
                    System.out.println("Digite a senha do usuário:");
                    String senha = scanner.nextLine();

                    Usuario usuario;
                    try {
                        usuario = sistema.cadastraUsuario(nome, email, senha);
                        System.out.println();
                        System.out.println("O usuário foi criado com sucesso");
                        System.out.println(usuario);
                        System.out.println();
                    }
                    catch (SenhaInvalidaException e) {
                        System.out.println();
                        System.out.println("A senha digitada é inválida");
                        System.out.println();
                    } catch (EmailInvalidoException e) {
                        System.out.println();
                        System.out.println("O email digitado é inválido");
                        System.out.println();
                    }
                    break;
            }

            Interface.showMenu();
            entrada = scanner.nextLine();
        }

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

//        Usuario usuario = sistema.cadastraUsuario("Hércules", "username@domain.com", "$0Password0");
//        System.out.println(usuario);

        Raizes raizes = sistema.calculaFuncaoSegundoGrau(2, 5, 2);
        System.out.println(raizes);

        Raizes raizes1 = sistema.calculaFuncaoSegundoGrau(2, 3, 2);
        System.out.println(raizes1);
    }
}
