import java.io.*;


public class ArquivoTextoLeitura {
    FileReader arq;
    BufferedReader lerArq;
    FileWriter arqEscrita;

    ArquivoTextoLeitura(String caminho) throws IOException {
        this.arq = new FileReader(caminho);
        this.lerArq = new BufferedReader(arq);
        this.arqEscrita = new FileWriter(caminho);
    }

    public String ler() throws IOException {
        String conteudo = "";
        String linha;
        linha = this.lerArq.readLine();
        return linha;
    }

    public String lerArquivoTodo() throws IOException {
        StringBuilder conteudo = new StringBuilder();
        String linha = "";
        while (linha != null) {
            linha = this.lerArq.readLine();
            conteudo.append(linha);
        }
        return conteudo.toString();
    }

    public void escrever(String conteudo) throws IOException {
        arqEscrita.write(conteudo);
    }

}
