import java.util.Scanner;

// Classe do login.
public class Login {
    // Senha padrao.
    private static String senha = "1234";

    // Getter da senha.
    public static String getSenha() { return senha; }

    // Setter da senha.
    public static void setSenha(String senha) { Login.senha = senha; }

    // Faz o login do usuario.
    public static boolean entrar() {
        Scanner sc = new Scanner(System.in);
        int tentativas = 0;

        // Tenta no maximo 3 vezes.
        while (tentativas < 3) {
            System.out.print("Usuario: ");
            String usuario = sc.next();
            System.out.print("Senha: ");
            String digitada = sc.next();

            // Compara usuario e senha.
            if (usuario.equals("admin") && digitada.equals(senha)) {
                System.out.println("Bem-vindo!\n");
                return true;
            }

            tentativas++;
            System.out.println("Incorreto! Tentativas restantes: " + (3 - tentativas));
        }

        System.out.println("Acesso bloqueado. Digite nova senha:");
        senha = sc.next();
        System.out.println("Nova senha salva. Faca login novamente.\n");
        return false;
    }

    // Texto da classe.
    @Override
    public String toString() {
        return "Login | senha protegida";
    }
}
