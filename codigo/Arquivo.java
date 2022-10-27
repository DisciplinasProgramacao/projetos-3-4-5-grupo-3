import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.FileReader;
import java.io.FileWriter;


public class Arquivo {
    public static String Read(String Caminho) throws IOException {
        String linha="";

            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            linha = lerArq.readLine();

        return linha;
    }

    public static boolean Write(String arquivo, String txt) {
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

