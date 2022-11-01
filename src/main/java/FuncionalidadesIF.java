public interface FuncionalidadesIF {
    public Usuario cadastraUsuario(String nome, String email, String senha) throws EmailInvalidoException, SenhaInvalidaException;
    public Raizes calculaFuncaoSegundoGrau(double a, double b, double c);
    public boolean ehTriangulo(double angulo1, double angulo2, double angulo3);
    public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3);
    public String classificaTriangulo(double angulo1, double angulo2, double angulo3);
    public boolean ehRetangulo(double lado1, double lado2, double lado3, double lado4);
    public double perimetroRetangulo(double lado1, double lado2, double lado3, double lado4) throws Exception;
    public double areaRetangulo(double lado1, double lado2, double lado3, double lado4) throws Exception;
    public double calculadora(String expressao);
    public double areaCirculo(double raio) throws Exception;
    public double areaPerimetro(double raio) throws Exception;
    public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2);
}