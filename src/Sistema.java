import java.util.ArrayList;
import java.util.regex.Pattern;

public class Sistema implements FuncionalidadesIF {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public boolean validarEmail(String email) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }

    public boolean validarSenha(String senha) {
        String regexPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=(.*\\d){2,})(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$";
        return Pattern.compile(regexPattern).matcher(senha).matches();
    }

    @Override
    public Usuario cadastraUsuario(String nome, String email, String senha) {
        if (validarEmail(email) && validarSenha(senha)) {
            Usuario usuario = new Usuario(nome, email, senha);
            this.usuarios.add(usuario);
            return usuario;
        }

        return null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public Raizes calculaFuncaoSegundoGrau(double a, double b, double c) {
        return null;
    }

    @Override
    public boolean ehTriangulo(double angulo1, double angulo2, double angulo3) {
        if (angulo1 <= 0 || angulo1 > 180) return false;
        if (angulo2 <= 0 || angulo2 > 180) return false;
        if (angulo3 <= 0 || angulo3 > 180) return false;
        return angulo1 + angulo2 + angulo3 == 180;
    }

    @Override
    public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3) {
        return (lado1 * lado1 + lado2 * lado2 == lado3 * lado3)
                || (lado3 * lado3 + lado2 * lado2 == lado1 * lado1)
                || (lado1 * lado1 + lado3 * lado3 == lado2 * lado2);
    }

    @Override
    public String classificaTriangulo(double angulo1, double angulo2, double angulo3) {
        // Adicionar condição para verificar se é triângulo
        if (angulo1 == 90 || angulo2 == 90 || angulo3 == 90)
            return "Triângulo retângulo";
        else if (angulo1 < 90 && angulo2 < 90 && angulo3 < 90)
            return "Triângulo acutângulo";
        else if (angulo1 > 90 || angulo2 > 90 || angulo3 > 90)
            return "Triângulo obtusângulo";

        return "Sem resultado";
    }

    @Override
    public boolean ehRetangulo(double lado1, double lado2, double lado3, double lado4) {
        if (lado1 >= 0 && lado2 >= 0 && lado3 >= 0 && lado4 >= 0) {
            return (lado1 == lado2 && lado3 == lado4)
                    || (lado1 == lado3 && lado2 == lado4)
                    || (lado1 == lado4 && lado2 == lado3);
        } else {
            return false;
        }
    }

    @Override
    public double perimetroRetangulo(double lado1, double lado2, double lado3, double lado4) {
        /*Os casos em que o perímetro dá erro se relaciona ao método ehRetangulo()*/
        try {
            if (ehRetangulo(lado1, lado2, lado3, lado4)) {
                return lado1 + lado2 + lado3 + lado4;
            } else {
                throw new Exception();
            }
        }
        catch(Exception e){
            System.out.println("Não foi possível calcular o perímetro. Verifique e tente novamente");
        }
        return -1;
    }

    @Override
    public double areaRetangulo(double lado1, double lado2, double lado3, double lado4) {
        double area = -1;
        /*Os casos em que o perímetro dá erro se relaciona ao método ehRetangulo()*/
        try {
            if (ehRetangulo(lado1, lado2, lado3, lado4)) {
                if (lado1 != lado2) {
                    area = lado1 * lado2;
                } else if (lado1 != lado3) {
                    area = lado1 * lado3;
                }
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println("Não foi possível calcular a área. Verifique e tente novamente.");
        }
        return Double.parseDouble(String.format("%.2f", area).replace(",", "."));
    }

    @Override
    public double calculadora(String expressao) {
        try {
            String[] operacao = expressao.trim().split("\\s+");
            double resultado = -1;
            double num1 = Double.parseDouble(operacao[0]);
            double num2 = Double.parseDouble(operacao[2]);
            switch (operacao[1]) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if(num2 != 0){
                        resultado = num1 / num2;
                    }
                    else{
                        throw new ArithmeticException();
                    }
                    break;
                case "^":
                    if(num2 < 0 && num1 == 0 ||  num1 < 0 && !operacao[2].matches("[0-9]*")){
                        /*Casos em que a potência não funciona:
                        *  1) Base igual a 0 e expoente negativo
                        *  2) Base negativa com expoente fracionário (positivo ou negativo)*/
                        throw new ArithmeticException();
                    }
                    resultado = Math.pow(num1, num2);
                    break;
            }
            return Double.parseDouble(String.format("%.2f", resultado).replace(",", "."));
        }
        catch (NumberFormatException err){
            /*Caso o usuário digite valores que não sejam números*/
            System.out.println("Digite números válidos para a operação. (Ex.: 2 / 2)");
        }
        catch (ArrayIndexOutOfBoundsException err){
            /*Caso o usuário não digite todas as informações necessárias e o array não tem o tamanho que deveria*/
            System.out.println("Digite números válidos para a opreção. (Ex.: 2 / 2)");
        }
        catch(ArithmeticException e ){
            /*Caso alguma operação dê erro, como divisão e potência.*/
            System.out.println("A operação é inválida. Tente realizar a operação com outros números.");
        }
        return -1;
    }

    @Override
    public double areaCirculo(double raio) {
        /*Dá erro caso o raio seja negativo ou zero*/
        double area = -1;
        try{
            if( raio > 0 ) {
                area = Math.PI * (raio * raio);
            }
            else{
                throw new Exception();
            }
        }
        catch(Exception e){
            System.out.println("Digite um valor de raio válido.");
            System.out.println("Apenas valores maiores do que zero são permitidos ;)");

        }
        return Double.parseDouble(String.format("%.2f", area).replace(",", "."));
    }

    @Override
    public double areaPerimetro(double raio) {
        /*Dá erro caso o raio seja negativo ou zero*/
        double perimetro = -1;
        try {
            if (raio > 0) {
                perimetro = 2 * Math.PI * raio;
            }
            else{
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println("Digite um valor de raio válido.");
            System.out.println("Apenas valores maiores do que zero são permitidos ;)");
        }
        return  Double.parseDouble(String.format("%.2f", perimetro).replace(",", "."));
    }

    @Override
    public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2) {
        return 0;
    }
}
