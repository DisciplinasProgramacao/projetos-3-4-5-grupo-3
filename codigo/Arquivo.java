import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class Arquivo {
    public static String Read(String Caminho) {
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    conteudo += linha+"\r\n";
                    linha = lerArq.readLine();
                }
                arq.close();
            }
            catch (IOException ex) {
                conteudo = "Erro -> Impossível ler arquivo.";
            }

        } catch (FileNotFoundException ex) {
            conteudo = "Erro -> Arquivo não encontrado.";
        }
        if (conteudo.contains("Erro")) {
            return "";
        } else {
            return conteudo;
        }
    }

    public static boolean Write (String arquivo, String txt) {
        try {
            FileWriter arq = new FileWriter(arquivo);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(txt);
            gravarArq.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
