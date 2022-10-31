public class Interface {
    public static void showMenu() {
        System.out.println("Olá, pessoal. Qual das nossas funcionalidades você gostaria de utilizar?");
        String menu = "   \n" +
                "   1. Cadastrar usuário\n" +
                "   2. Calcular equação de segundo grau\n" +
                "   3. Verificar lados de um triângulo\n" +
                "   4. Classificar triângulo\n" +
                "   5. Verificar lados de um triângulo retângulo\n" +
                "   6. Validar retângulo\n" +
                "   7. Calcular área e perímetro de um retângulo\n" +
                "   8. Calculadora\n" +
                "   9. Calcular área e perímetro de um círculo\n" +
                "   10. Calcular distância entre dois pontos\n";
        System.out.println(menu);
        System.out.println("Escolha alguma das opções acima:");
    }
}
