public class MainApplication {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        System.out.println(sistema.classificaTriangulo(60, 60, 60));
        System.out.println(sistema.ehTrianguloRetangulo(5, 4, 3));
        System.out.println(sistema.ehRetangulo(1, 1, 2, 2));
        System.out.println(sistema.ehRetangulo(1, 2, 3, 4));
        System.out.println(sistema.ehRetangulo(4, 4, 4, 4));
        System.out.println(sistema.areaRetangulo(2.5, 3, 3, 2.5));
        System.out.println(sistema.calculadora("       2     /    0      "));
        System.out.println(sistema.calculadora(" 5.235 ^ 3"));


        sistema.cadastraUsuario("Hércules", "username@domain.com", "$0Password0");
    }
}
