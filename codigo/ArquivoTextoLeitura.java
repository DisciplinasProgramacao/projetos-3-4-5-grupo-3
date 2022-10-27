//import java.io.*;
//
//
//public class ArquivoTextoLeitura {
//    FileReader arq;
//    BufferedReader lerArq;
//    FileWriter arqEscrita;
//
//    ArquivoTextoLeitura(String caminho) throws IOException {
//        this.arq = new FileReader(caminho);
//        this.lerArq = new BufferedReader(arq);
//        this.arqEscrita = new FileWriter(caminho);
//    }
//
////    public static String Read(String Caminho) {
////        String conteudo = "";
////        try {
////            FileReader arq = new FileReader(Caminho);
////            BufferedReader lerArq = new BufferedReader(arq);
////            String linha = "";
////            try {
////                linha = lerArq.readLine();
////                while (linha != null) {
////                    conteudo += linha+"\r\n";
////                    linha = lerArq.readLine();
////                }
////                arq.close();
////            }
////            catch (IOException ex) {
////                conteudo = "Erro -> Impossível ler arquivo.";
////            }
////
////        } catch (FileNotFoundException ex) {
////            conteudo = "Erro -> Arquivo não encontrado.";
////        }
////        if (conteudo.contains("Erro")) {
////            return "";
////        } else {
////            return conteudo;
////        }
////    }
//
//    public String ler() throws IOException {
//        String linha;
//        linha = lerArq.readLine();
//        return linha;
//    }
//
//    public String lerArquivoTodo() throws IOException {
//        StringBuilder conteudo = new StringBuilder();
//        String linha = "";
//        while (linha != null) {
//            linha = this.lerArq.readLine();
//            conteudo.append(linha);
//        }
//        return conteudo.toString();
//    }
//
//    public void escrever(String conteudo) throws IOException {
//        arqEscrita.write(conteudo);
//    }
//
//}



