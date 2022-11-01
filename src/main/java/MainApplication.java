import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        sistema.setup();

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
                case "7":
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Digite os valores dos lados do retângulo: \n");
                    try{
                        double[] lados = new double[4];
                        for (int i = 0; i < 4; i++) {
                            System.out.printf("Lado %d: ", i+1);
                            double lado = sc.nextDouble();
                            lados[i] = lado;
                        }
                        System.out.printf("A área do retângulo é: %.2f\n", sistema.areaRetangulo(lados[0], lados[1], lados[2], lados[3]));
                        System.out.printf("O perímetro do retângulo é: %.2f\n", sistema.perimetroRetangulo(lados[0], lados[1], lados[2], lados[3]));
                    }
                    catch (InputMismatchException e){
                        System.out.println("Dados inválidos. Digite 4 valores númericos positivos que representem os lados de um retângulo.");
                    }
                    catch (Exception e){
                        System.out.println("Não foi possível calcular o perímetro. Verifique os valores e tente novamente.");
                    }
                    break;
                case "8":
                    System.out.print("Digite a expressão desejada (Ex.: 6 * 2): ");
                    String operacao = scanner.nextLine();
                    try{
                        System.out.printf("O resultado da operação é: %.2f\n", sistema.calculadora(operacao));
                    }
                    catch (NumberFormatException e){
                        /*Caso o usuário digite valores que não sejam números ou deixe algum número em branco*/
                        System.out.println("Digite números válidos para a operação separados por espaços. (Ex.: 6 / 2)");
                    }
                    catch(ArithmeticException e ){
                        /*Caso alguma operação dê erro, como divisão e potência.*/
                        System.out.println("A operação é inválida. Tente realizar a operação com outros números.");
                    }
                    break;
                case "9":
                    Scanner sc1 = new Scanner(System.in);
                    System.out.print("Digite o valor do raio do círculo: ");
                    try{
                        double raio = sc1.nextDouble();
                        System.out.printf("A área do círculo é: %.2f\n", sistema.areaCirculo(raio));
                        System.out.printf("O perímetro do círculo é: %.2f\n", sistema.areaPerimetro(raio));
                    } catch (InputMismatchException e){
                        System.out.println("Digite um valor de raio válido.");
                    } catch(Exception e){
                        System.out.println("Digite um valor de raio válido.");
                        System.out.println("Apenas valores maiores do que zero são permitidos ;)");
                    }
                    break;
            }
            Interface.showMenu();
            entrada = scanner.nextLine();
        }
    }
}
