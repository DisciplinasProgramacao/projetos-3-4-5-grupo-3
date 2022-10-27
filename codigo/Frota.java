import java.io.IOException;
import java.util.ArrayList;


public class Frota {
    private final ArrayList<Veiculo> listaVeiculos;
    //private final ArquivoTextoLeitura arquivo;
    private final Arquivo arquivo;
    String arquivoLista;
    private static final int INDEX_TIPO_VEICULO = 0;
    private static final int INDEX_PRECO = 2;
    private static final int INDEX_KM_MEDIA = 3;
    private static final int INDEX_PLACA = 1;

    public Frota() throws IOException {
        listaVeiculos = new ArrayList<>();
        //arquivo = new ArquivoTextoLeitura(caminhoArquivo);
        this.arquivo = new Arquivo();
    }

    public void carregarDoArquivo(String caminhoArquivo) throws IOException {
        this.arquivoLista = caminhoArquivo;
        for (int i = 0; i < arquivoLista.length(); i++) {
            String txt = Arquivo.Read(arquivoLista);
            if(txt.isEmpty()) {
                System.out.println("Arquivo vazio");
            } else System.out.println(txt);
        }

    }

    public void salvarVeiculoArquivo(String dadosVeiculo) throws IOException {
        String[] vetorDados = converteEmVetor(dadosVeiculo);
        Arquivo.Write(arquivoLista,vetorDados[INDEX_TIPO_VEICULO] + ";" + vetorDados[INDEX_PRECO] + ";" + vetorDados[INDEX_TIPO_VEICULO]);
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
