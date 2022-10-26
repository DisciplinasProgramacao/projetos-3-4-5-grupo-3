import java.io.IOException;
import java.util.ArrayList;


public class Frota {
    private final ArrayList<Veiculo> listaVeiculos;
    private final ArquivoTextoLeitura arquivo;
    private static final int INDEX_TIPO_VEICULO = 0;
    private static final int INDEX_PRECO = 2;
    private static final int INDEX_KM_MEDIA = 3;
    private static final int INDEX_PLACA = 1;

    public Frota(String caminhoArquivo) throws IOException {
        listaVeiculos = new ArrayList<>();
        this.arquivo = new ArquivoTextoLeitura(caminhoArquivo);
    }

    public void carregarDoArquivo() throws IOException {
        String linha = arquivo.ler();
        while (linha != null) {
            linha = arquivo.ler();
            insereNaFrota(linha);
        }
    }

    public void salvarVeiculoArquivo(String dadosVeiculo) throws IOException {
        String[] vetorDados = converteEmVetor(dadosVeiculo);
        arquivo.escrever(vetorDados[INDEX_TIPO_VEICULO] + ";" + vetorDados[INDEX_PRECO] + ";" + vetorDados[INDEX_TIPO_VEICULO]);
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
            case "Caminhao" -> "Caminhao";
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
        }
        return conteudo.toString();
    }
}
