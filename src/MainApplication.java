public class MainApplication {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        System.out.println(sistema.classificaTriangulo(60, 60, 60));
        System.out.println(sistema.ehTrianguloRetangulo(5, 4, 3));
        System.out.println(sistema.ehRetangulo(1, 1, 2, 2));
        System.out.println(sistema.ehRetangulo(1, 2, 3, 4));

        sistema.cadastraUsuario("Hércules", "username@domain.com", "$0Password0");
    }
}
