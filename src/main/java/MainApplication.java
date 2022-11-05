import java.util.ArrayList;
import java.util.InputMismatchException;

public class MainApplication {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        sistema.setup();

        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Cadastrar clientes");
        opcoes.add("Calcular equação de segundo grau");
        opcoes.add("Verificar lados de um triângulo");
        opcoes.add("Classificar triângulo");
        opcoes.add("Verificar lados de um triângulo retângulo");
        opcoes.add("Validar retângulo");
        opcoes.add("Calcular área e perímetro de um retângulo");
        opcoes.add("Calculadora");
        opcoes.add("Calcular área e perímetro de um círculo");
        opcoes.add("Calcular distância entre dois pontos");
        opcoes.add("Sair");

        System.out.println("Olá, pessoal!");

        String opcaoEscolhida = null;
        boolean rodarSistema = true;
        boolean isMostrarMenu = true;
        while (rodarSistema) {
            if (isMostrarMenu) {
                opcaoEscolhida = Interface.mostrarMenu("\nQual das nossas funcionalidades você gostaria de utilizar?", opcoes);
            }

            isMostrarMenu = true;

            switch (opcaoEscolhida) {
                case "1" -> {
                    System.out.println("\nVamos cadastrar um novo cliente.");
                    System.out.println("Para realizar essa operação vamos precisar de algumas informações.");
                    String nome = Interface.pedirEntrada("Digite o nome do usuário:");
                    String email = Interface.pedirEntrada("Digite o email do usuário:");
                    String senha = Interface.pedirEntrada("Digite a senha do usuário:");

                    try {
                        Usuario usuario = sistema.cadastraUsuario(nome, email, senha);
                        System.out.println();
                        System.out.println("O usuário foi criado com sucesso.");
                        System.out.println(usuario);
                        System.out.println();
                    } catch (EmailInvalidoException e) {
                        isMostrarMenu = Interface.lidarComErro(Usuario.isSenhaValida(senha) ? "O email digitado é inválido." : "O email e a senha são inválidos.");
                    } catch (SenhaInvalidaException e) {
                        isMostrarMenu = Interface.lidarComErro("A senha digitada é inválida.");
                    }
                }
                case "2" -> {
                    System.out.println("\nPara calcular as raízes de uma equação de segundo grau vamos precisar dos coeficientes.");
                    try {
                        double a = Double.parseDouble(Interface.pedirEntrada("Digite o coeficiente a:"));
                        double b = Double.parseDouble(Interface.pedirEntrada("Digite o coeficiente b:"));
                        double c = Double.parseDouble(Interface.pedirEntrada("Digite o coeficiente c:"));
                        System.out.println("A equação acima possui as seguintes raízes:");
                        Raizes raizes = sistema.calculaFuncaoSegundoGrau(a, b, c);
                        System.out.println(raizes != null ? raizes : "Sem raízes reais.");
                    }
                    catch (Exception e) {
                        isMostrarMenu = Interface.lidarComErro("Os coeficientes digitados são inválidos.");
                    }
                }
                case "3" -> {
                    System.out.println("\nPreencha os valores dos lados do triângulo.");
                    try {
                        double lado1 = Double.parseDouble(Interface.pedirEntrada("Lado 1:"));
                        double lado2 = Double.parseDouble(Interface.pedirEntrada("Lado 2:"));
                        double lado3 = Double.parseDouble(Interface.pedirEntrada("Lado 3:"));
                        System.out.println(sistema.ehTriangulo(lado1, lado2, lado3) ? "\nÉ um triângulo." : "\nNão é um triângulo.");
                    }
                    catch (Exception e) {
                        isMostrarMenu = Interface.lidarComErro("Os valores dos lados digitados são inválidos.");
                    }
                }
                case "7" -> {
                    System.out.print("\nDigite os valores dos lados do retângulo: \n");
                    try {
                        double[] lados = new double[4];
                        for (int i = 0; i < 4; i++) {
                            double lado = Double.parseDouble(Interface.pedirEntrada(String.format("Lado %d", i + 1)));
                            lados[i] = lado;
                        }
                        System.out.printf("A área do retângulo é: %.2f\n", sistema.areaRetangulo(lados[0], lados[1], lados[2], lados[3]));
                        System.out.printf("O perímetro do retângulo é: %.2f\n", sistema.perimetroRetangulo(lados[0], lados[1], lados[2], lados[3]));
                    }
                    catch (InputMismatchException e){
                        isMostrarMenu = Interface.lidarComErro("Dados inválidos. Digite 4 valores númericos positivos que representem os lados de um retângulo.");
                    }
                    catch (Exception e){
                        isMostrarMenu = Interface.lidarComErro("Não foi possível calcular o perímetro.");
                    }
                }
                case "8" -> {
                    String operacao = Interface.pedirEntrada("Digite a expressão desejada (Ex.: 6 * 2): ");
                    try {
                        System.out.printf("O resultado da operação é: %.2f\n", sistema.calculadora(operacao));
                    }
                    catch (NumberFormatException e){
                        /*Caso o usuário digite valores que não sejam números ou deixe algum número em branco*/
                        isMostrarMenu = Interface.lidarComErro("Digite números válidos para a operação separados por espaços. (Ex.: 6 / 2)");
                    }
                    catch(ArithmeticException e ){
                        /*Caso alguma operação dê erro, como divisão e potência.*/
                        isMostrarMenu = Interface.lidarComErro("A operação é inválida. Tente realizar a operação com outros números.");
                    }
                }
                case "9" -> {
                    try {
                        double raio = Double.parseDouble(Interface.pedirEntrada("\nDigite o valor do raio do círculo:"));
                        System.out.printf("A área do círculo é: %.2f\n", sistema.areaCirculo(raio));
                        System.out.printf("O perímetro do círculo é: %.2f\n", sistema.areaPerimetro(raio));
                    } catch (InputMismatchException e) {
                        isMostrarMenu = Interface.lidarComErro("Digite um valor de raio válido.");
                    } catch (Exception e){
                        isMostrarMenu = Interface.lidarComErro("Digite um valor de raio válido.\nApenas valores maiores do que zero são permitidos.");
                    }
                }
                case "10" -> {
                    try {
                        String p1 = Interface.pedirEntrada("Digite as coordenadas do ponto 1 (x1 y1) separados por espaço: (Ex.: 0 3) ");
                        String[] ponto1 = p1.trim().split("\\s+");
                        double x1 = Double.parseDouble(ponto1[0]);
                        double y1 = Double.parseDouble(ponto1[1]);
                        String p2 = Interface.pedirEntrada("Digite as coordenadas do ponto 2 (x2 y2) separados por espaço: (Ex.: 0 3)");
                        String[] ponto2 = p2.trim().split("\\s+");
                        double x2 = Double.parseDouble(ponto2[0]);
                        double y2 = Double.parseDouble(ponto2[1]);
                        System.out.printf("A ditância entre os pontos é: %.2f\n", sistema.distanciaEntreDoisPontos(x1, y1, x2, y2));
                    }
                    catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
                        isMostrarMenu = Interface.lidarComErro("Coordenadas inválidas. Digite as coordenadas de cada ponto separado por espaço (Ex.: 0 3)");
                    }
                }
                case "11" -> rodarSistema = false;
            }
        }
    }
}
