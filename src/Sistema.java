public class Sistema implements FuncionalidadesIF {
    @Override
    public Usuario cadastraUsuario(String nome, String email, String senha) {
        return null;
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
        return false;
    }

    @Override
    public double perimetroRetangulo(double lado1, double lado2, double lado3, double lado4) {
        return 0;
    }

    @Override
    public double areaRetangulo(double lado1, double lado2, double lado3, double lado4) {
        return 0;
    }

    @Override
    public double calculadora(String expressao) {
        return 0;
    }

    @Override
    public double areaCirculo(double raio) {
        return 0;
    }

    @Override
    public double areaPerimetro(double raio) {
        return 0;
    }

    @Override
    public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2) {
        return 0;
    }
}
