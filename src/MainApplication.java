public class MainApplication {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        System.out.println(sistema.classificaTriangulo(60, 60, 60));
        System.out.println(sistema.ehTrianguloRetangulo(5, 4, 3));

        sistema.cadastraUsuario("Hércules", "username@domain.com", "123");
    }
}
