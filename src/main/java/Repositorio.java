import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Repositorio {
    private static final Type TIPO_USUARIO = new TypeToken<ArrayList<Usuario>>() {}.getType();

    public static void criarArquivo() {
        try {
            File arquivo = new File("usuarios.json");

            if (arquivo.createNewFile()) {
                System.out.println("Arquivo de usuários criado com sucesso.");
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao tentar criar o arquivo de usuários.");

            e.printStackTrace();
        }
    }

    public static void salvarUsuariosNoArquivo(ArrayList<Usuario> usuarios) {
        try (Writer escritor = new FileWriter("usuarios.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            gson.toJson(usuarios, escritor);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao tentar salvar usuário no arquivo.");

            e.printStackTrace();
        }
    }

    public static ArrayList<Usuario> importarUsuariosDoArquivo() {
        try (Reader leitor = new FileReader("usuarios.json")) {
            Gson gson = new Gson();

            ArrayList<Usuario> usuarios = gson.fromJson(new JsonReader(leitor), TIPO_USUARIO);

            return usuarios != null ? usuarios : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Não foi possível encontrar o arquivo de usuários.");

            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
