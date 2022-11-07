import java.util.ArrayList;

class EmailInvalidoException extends Exception {}

class SenhaInvalidaException extends Exception {}

public class Sistema implements FuncionalidadesIF {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void setup() {
        Repositorio.criarArquivo();
        this.usuarios = Repositorio.importarUsuariosDoArquivo();
    }

    @Override
    public Usuario cadastraUsuario(String nome, String email, String senha) throws EmailInvalidoException, SenhaInvalidaException {
        if (Usuario.isEmailValido(email)) {
            if (Usuario.isSenhaValida(senha)) {
                Usuario usuario = new Usuario(nome, email, senha);
                this.usuarios.add(usuario);

                Repositorio.salvarUsuariosNoArquivo(this.usuarios);

                return usuario;
            }
            else {
                throw new SenhaInvalidaException();
            }
        }
        else {
            throw new EmailInvalidoException();
        }
    }

    @Override
    public Raizes calculaFuncaoSegundoGrau(double a, double b, double c) {
        if (a != 0) {
            double delta = Math.pow(b, 2) - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                return new Raizes(x1, x2);
            }
            if (delta == 0) {
                double x = -b / 2 * a;
                return new Raizes(x, x);
            }
        }
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
    public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3) throws Exception {
        if (lado1 > 0 && lado2 > 0 && lado3 > 0) {
            return (lado1 * lado1 + lado2 * lado2 == lado3 * lado3)
                    || (lado3 * lado3 + lado2 * lado2 == lado1 * lado1)
                    || (lado1 * lado1 + lado3 * lado3 == lado2 * lado2);
        } else {
            throw new Exception();
        }
    }

    @Override
    public String classificaTriangulo(double angulo1, double angulo2, double angulo3) throws Exception {
        if (ehTriangulo(angulo1, angulo2, angulo3)) {
            if (angulo1 == 90 || angulo2 == 90 || angulo3 == 90)
                return "Triângulo retângulo";
            else if (angulo1 < 90 && angulo2 < 90 && angulo3 < 90)
                return "Triângulo acutângulo";
            else if (angulo1 > 90 || angulo2 > 90 || angulo3 > 90)
                return "Triângulo obtusângulo";
        } else {
            throw new Exception();
        }

        return null;
    }

    @Override
    public boolean ehRetangulo(double lado1, double lado2, double lado3, double lado4) throws Exception {
        if (lado1 > 0 && lado2 > 0 && lado3 > 0 && lado4 > 0) {
            return (lado1 == lado2 && lado3 == lado4)
                    || (lado1 == lado3 && lado2 == lado4)
                    || (lado1 == lado4 && lado2 == lado3);
        } else {
            throw new Exception();
        }
    }

    @Override
    public double perimetroRetangulo(double lado1, double lado2, double lado3, double lado4) throws Exception{
        /*Os casos em que o perímetro dá erro se relaciona ao método ehRetangulo()*/
        if (ehRetangulo(lado1, lado2, lado3, lado4)) {
            return lado1 + lado2 + lado3 + lado4;
        } else {
            throw new Exception();
        }
    }

    @Override
    public double areaRetangulo(double lado1, double lado2, double lado3, double lado4) throws Exception{
        /*Os casos em que o perímetro dá erro se relaciona ao método ehRetangulo()*/
        if (ehRetangulo(lado1, lado2, lado3, lado4)) {
            double area = 0;
            if(lado1 == lado2 && lado2 == lado3 && lado3 == lado4){
                area =lado1 *lado2;
            }
            if (lado1 != lado2) {
                area = lado1 * lado2;
            } else if (lado1 != lado3) {
                area = lado1 * lado3;
            }
            return Double.parseDouble(String.format("%.2f", area).replace(",", "."));
        }
        else {
            throw new Exception();
        }
    }

    @Override
    public double calculadora(String expressao) throws NumberFormatException, ArithmeticException{
        String[] operacao = expressao.trim().split("\\s+");
        if (operacao.length != 3|| operacao[0].isEmpty() || operacao[2].isEmpty() || operacao[1].isEmpty()) {
            throw new NumberFormatException();
        }
        double resultado;
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
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    throw new ArithmeticException();
                }
                break;
            case "**":
                if (num2 < 0 && num1 == 0 || !operacao[2].matches("-?[0-9]*")) {
                    /*Casos em que a potência não funciona:
                     *  1) Base igual a 0 e expoente negativo
                     *  2) Expoente fracionário (positivo ou negativo)*/
                    throw new ArithmeticException();
                }
                resultado = Math.pow(num1, num2);
                break;
            default:
                throw new ArithmeticException();
        }
        return Double.parseDouble(String.format("%.2f", resultado).replace(",", "."));
    }

    @Override
    public double areaCirculo(double raio) throws Exception{
        /*Dá erro caso o raio seja negativo ou zero*/
        if( raio > 0 ) {
            double area = Math.PI * (raio * raio);
            return Double.parseDouble(String.format("%.2f", area).replace(",", "."));
        }
        else{
            throw new Exception();
        }
    }

    @Override
    public double areaPerimetro(double raio) throws Exception{
        /*Dá erro caso o raio seja negativo ou zero*/
        if (raio > 0) {
            double perimetro = 2 * Math.PI * raio;
            return  Double.parseDouble(String.format("%.2f", perimetro).replace(",", "."));
        }
        else{
            throw new Exception();
        }
    }

    @Override
    public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2) {
        double dist = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
        return Double.parseDouble(String.format("%.2f", dist).replace(",", "."));

    }
}
