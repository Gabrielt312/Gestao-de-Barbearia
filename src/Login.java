import java.util.Scanner;

public class Login {
    private static String senha = "1234";

    public static boolean entrar() {
        Scanner sc = new Scanner(System.in);
        int tentativas = 0;

        while (tentativas < 3) {
            System.out.print("Usuario: ");
            String usuario = sc.next();
            System.out.print("Senha: ");
            String digitada = sc.next();

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
}
