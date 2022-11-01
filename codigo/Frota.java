import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Frota {
    private ArrayList<Veiculo> listaVeiculos;
    private static final int INDEX_TIPO_VEICULO = 0;
    private static final int INDEX_PRECO = 2;
    private static final int INDEX_KM_MEDIA = 3;
    private static final int INDEX_PLACA = 1;

    public Frota() throws IOException {
        listaVeiculos = new ArrayList<>();
    }

    /**
     * Salva um arquivo que representa um vetor de veiculos
     *
     * @param nomeArquivo nome do arquivo a ser salvo
     */
    public void salvar(String nomeArquivo) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nomeArquivo));
        String linha = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo: ");
        linha = in.nextLine();
        buffWrite.append(linha).append("\n");
        buffWrite.close();
    }

    /**
     * Lê um arquivo que representa uma frota de veiculos
     *
     * @param nomeArquivo nome do arquivo a ser lido
     */
    public void carregar(String nomeArquivo) throws IOException, ClassNotFoundException {
        BufferedReader buffRead = new BufferedReader(new FileReader(nomeArquivo));
        String linha = "";
        while (true) {
            if (linha != null) {

                System.out.println(linha);
            } else {
                break;
            }
            linha = buffRead.readLine();
            if (linha != null)
                insereNaFrota(linha);
        }
        buffRead.close();

    }

    /**
     * Método que recebe os dados do Veiculo e insere na frota.
     *
     * @param dadosVeiculo String no formato String Tipo; double Preco; double kmMedia
     */
    public void insereNaFrota(String dadosVeiculo) {
        String tipoVeiculo = verificaTipo(dadosVeiculo);
        String[] vetorDados = converteEmVetor(dadosVeiculo);
        double preco = Double.parseDouble(vetorDados[INDEX_PRECO]);
        double kmMedia = Double.parseDouble(vetorDados[INDEX_KM_MEDIA]);
        String placa = vetorDados[INDEX_PLACA];

        switch (tipoVeiculo) {
            case "Carro" -> insereCarro(preco, placa, kmMedia);
            case "Van" -> insereVan(preco, placa, kmMedia);
            case "Furgao" -> insereFurgao(preco, placa, kmMedia);
            case "Caminhao" -> insereCaminhao(preco, placa, kmMedia);
        }
    }

    private void insereCaminhao(double preco, String placa, double kmMedia) {
        Caminhao caminhao = new Caminhao(preco, placa, kmMedia);
        listaVeiculos.add(caminhao);
    }

    private void insereFurgao(double preco, String placa, double kmMedia) {
        Furgao furgao = new Furgao(preco, placa, kmMedia);
        listaVeiculos.add(furgao);
    }

    private void insereVan(double preco, String placa, double kmMedia) {
        Van van = new Van(preco, placa, kmMedia);
        listaVeiculos.add(van);
    }

    private void insereCarro(double preco, String placa, double kmMedia) {
        Carro carro = new Carro(preco, placa, kmMedia);
        listaVeiculos.add(carro);
    }

    private String verificaTipo(String linha) {
        String[] vetorDados = converteEmVetor(linha);
        return switch (vetorDados[INDEX_TIPO_VEICULO]) {
            case "Carro" -> "Carro";
            case "Furgao" -> "Furgao";
            case "Van" -> "Van";
            default -> "Caminhao";
        };
    }

    private String[] converteEmVetor(String linha) {
        return linha.split(";");
    }

    @Override
    public String toString() {
        StringBuilder conteudo = new StringBuilder();
        for (Veiculo veiculo : listaVeiculos) {
            conteudo.append(veiculo.toString());
            conteudo.append("\n");
        }
        return conteudo.toString();
    }

    public Veiculo procurar(String placaProcurar) {

        for (Veiculo veiculo : listaVeiculos) {
            if (placaProcurar.equals(veiculo.placa)) {
                return veiculo;
            }
        }

        return null;
    }
}
