import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class Arquivo {
    /**
     * Método que lê o dado de um arquivo .txt
     * @param Caminho O local onde o arquivo se encontra
     * @return Todos os dados do arquivo
     */
    public static String Read(String Caminho) {
        StringBuilder conteudo = new StringBuilder();
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    conteudo.append(linha).append("\r\n");
                    linha = lerArq.readLine();
                }
                arq.close();
            }
            catch (IOException ex) {
                conteudo = new StringBuilder("Erro -> Impossível ler arquivo.");
            }

        } catch (FileNotFoundException ex) {
            conteudo = new StringBuilder("Erro -> Arquivo não encontrado.");
        }
        if (conteudo.toString().contains("Erro")) {
            return "";
        } else {
            return conteudo.toString();
        }
    }

    /**
     * Método que escreve uma String no arquivo
     * @param arquivo O arquivo a ser utilizado
     * @param txt O texto que será escrito
     * @return True se não ocorrer nenhum erro durante a escrita, False se não for possivel
     */
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
