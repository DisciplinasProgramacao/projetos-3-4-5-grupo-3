import java.io.*;
import java.util.*;


public class Frota {
    public final ArrayList<Veiculo> listaVeiculos;
    private static final int INDEX_TIPO_VEICULO = 0;
    private static final int INDEX_PLACA = 1;
    private static final int INDEX_PRECO = 2;

    public Frota() {
        listaVeiculos = new ArrayList<>();
    }

    /**
     * Salva um arquivo que representa um vetor de veiculos
     *
     * @param nomeArquivo nome do arquivo a ser salvo
     */
    public void salvar(String nomeArquivo) throws IOException {
        BufferedWriter arquivoEscrita = new BufferedWriter(new FileWriter(nomeArquivo, true));
        String linha;
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo no formato: | Tipo;Placa;preco;kmMédia |");
        linha = in.nextLine();
        arquivoEscrita.append("\n").append(linha);
        arquivoEscrita.close();
    }

    /**
     * Lê um arquivo que representa uma frota de veiculos
     *
     * @param nomeArquivo nome do arquivo a ser lido
     */
    public void carregar(String nomeArquivo) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(nomeArquivo));
        String linha = buffRead.readLine();
        while (true) {
            if (linha != null) {
                System.out.println(linha);
                insereNaFrota(linha);
            } else {
                break;
            }
            linha = buffRead.readLine();
            if (linha != null && !linha.equals(""))
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
        String tipoVeiculo = verificaTipoVeiculo(dadosVeiculo);
        String[] vetorDados = converteEmVetor(dadosVeiculo);
        double preco = Double.parseDouble(vetorDados[INDEX_PRECO]);

        String placa = vetorDados[INDEX_PLACA];
        insereVeiculo(tipoVeiculo, preco, placa);
    }

    private void insereVeiculo(String tipo, double preco, String placa) {

        switch (tipo) {
            case "Caminhao" -> {
                Caminhao caminhao = new Caminhao(preco, placa);
                listaVeiculos.add(caminhao);
            }
            case "Carro" -> {
                Carro carro = new Carro(preco, placa);
                listaVeiculos.add(carro);
            }
            case "Furgao" -> {
                Furgao furgao = new Furgao(preco, placa);
                listaVeiculos.add(furgao);
            }
            case "Van" -> {
                Van van = new Van(preco, placa);
                listaVeiculos.add(van);
            }
        }
    }


    private String verificaTipoVeiculo(String linha) {
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

    private ArrayList<Veiculo> ordenar(String criterio) {
        if ("Rotas".equals(criterio)) {
            return (ArrayList<Veiculo>) this.listaVeiculos
                    .stream().sorted(Comparator.comparing(Veiculo::getNumRotas).reversed()).toList();
        }


        return null;
    }

    public void kmMediaDasRotas() {
        int qtdRotas = 0;
        double totalRotas = 0;
        for (Veiculo veiculo : listaVeiculos) {
            for (Rota rota : veiculo.listaRotas) {
                qtdRotas++;
                totalRotas += rota.getDistancia();
            }
        }
        double mediaRotas = totalRotas / qtdRotas;
        System.out.println("A media entre as rotas da empresa é:" + (mediaRotas));
    }

    public ArrayList<Veiculo> maisRotas() {
        ArrayList<Veiculo> sortedListaVeiculos = ordenar("Rota");
        if (sortedListaVeiculos == null)
            return null;
        return (ArrayList<Veiculo>) sortedListaVeiculos.stream().limit(3).toList();
    }

    public void ordenarCustoDecrescentes() {
        Collections.sort(listaVeiculos);
        System.out.println(listaVeiculos);
    }

    public void rotasPorData(Date data) {
        for (Veiculo veiculo : listaVeiculos) {
            for (Rota rota : veiculo.listaRotas) {
                if (rota.getData().equals(data))
                    System.out.println(rota);
            }
        }
    }
}
