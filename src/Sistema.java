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
        if (validarEmail(email)) {
            System.out.println("Email válido");
        }
        else {
            System.out.println("Email inválido");
        }

        System.out.println(validarSenha(senha) ? "Senha válida" : "Senha inválida");

        return null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public Raizes calculaFuncaoSegundoGrau(double a, double b, double c) {
        return null;
    }

    @Override
    public boolean ehTriangulo(double angulo1, double angulo2, double angulo3) {
        return false;
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
        //Validações para valores <= 0
        return (lado1 == lado2 && lado3 == lado4 && lado1 != lado3)
                || (lado1 == lado3 && lado2 == lado4 && lado1 != lado2)
                || (lado1 == lado4 && lado2 == lado3 && lado1 != lado2);
    }

    @Override
    public double perimetroRetangulo(double lado1, double lado2, double lado3, double lado4) {
        if(ehRetangulo(lado1, lado2, lado3, lado4)) {
            return lado1 + lado2 + lado3 + lado4;
        }
        return -1;
    }

    @Override
    public double areaRetangulo(double lado1, double lado2, double lado3, double lado4) {
        double area = -1;
        if(ehRetangulo(lado1, lado2, lado3, lado4)){
            if(lado1 != lado2){
                area = lado1*lado2;
            }
            else if(lado1 != lado3) {
                area = lado1*lado3;
            }
        }
        return Double.parseDouble(String.format("%.2f", area).replace(",", "."));
    }

    @Override
    public double calculadora(String expressao) {
        String[] operacao = expressao.trim().split("\\s+");
        double resultado = -1;
        if(operacao.length == 3) {
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
                    break;
                case "^":
                    resultado = Math.pow(num1, num2);
                    break;
            }
        }
        return Double.parseDouble(String.format("%.2f", resultado).replace(",", "."));
    }

    @Override
    public double areaCirculo(double raio) {
        double area = -1;
        if( raio > 0 ){
            area = Math.PI * (raio*raio);
        }
        return Double.parseDouble(String.format("%.2f", area).replace(",", "."));
    }

    @Override
    public double areaPerimetro(double raio) {
        double perimetro = -1;
        if(raio > 0){
            perimetro = 2 * Math.PI * raio;
        }
        return  Double.parseDouble(String.format("%.2f", perimetro).replace(",", "."));
    }

    @Override
    public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2) {
        return 0;
    }
}
