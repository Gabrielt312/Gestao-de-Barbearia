import java.io.*;
import java.util.ArrayList;

public class Arquivos {

    public static void salvar(String arquivo, ArrayList<?> lista) {
        try {
            FileWriter fw = new FileWriter(arquivo);
            for (Object obj : lista) fw.write(obj.toString() + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public static ArrayList<String> carregar(String arquivo) {
        ArrayList<String> linhas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha;
            while ((linha = br.readLine()) != null)
                if (!linha.trim().isEmpty()) linhas.add(linha);
            br.close();
        } catch (IOException e) { /* arquivo ainda nao existe */ }
        return linhas;
    }
}
