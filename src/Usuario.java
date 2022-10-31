import java.util.regex.Pattern;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public static boolean isEmailValido(String email) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }

    public static boolean isSenhaValida(String senha) {
        String regexPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=(.*\\d){2,})(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$";
        return Pattern.compile(regexPattern).matcher(senha).matches();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
