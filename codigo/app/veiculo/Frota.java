package app.veiculo;

import app.fabricas.FabricaVeiculo;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Frota {
    //region #attributes
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
    public void carregar(String nomeArquivo) throws Exception {
        BufferedReader buffRead = new BufferedReader(new FileReader(nomeArquivo));
        String linha = buffRead.readLine();
        while (linha != null) {
            System.out.println(linha);
            insereNaFrota(linha);
            linha = buffRead.readLine();
            if (!linha.equals(""))
                insereNaFrota(linha);
        }
        buffRead.close();
    }

    /**
     * Método que recebe os dados do app.veiculo.Veiculo e insere na frota.
     *
     * @param dadosVeiculo String no formato String Tipo; double Preco; double kmMedia
     */
    public void insereNaFrota(String dadosVeiculo) throws Exception {
        String tipoVeiculo = verificaTipoVeiculo(dadosVeiculo);
        String[] vetorDados = converteEmVetor(dadosVeiculo);
        double preco = Double.parseDouble(vetorDados[INDEX_PRECO]);

        String placa = vetorDados[INDEX_PLACA];
        insereVeiculo(tipoVeiculo, preco, placa);
    }

    private void insereVeiculo(String tipo, double preco, String placa) throws Exception {
        FabricaVeiculo.criarVeiculo(tipo, preco, placa);
    }


    private String verificaTipoVeiculo(String linha) {
        String[] vetorDados = converteEmVetor(linha);
        return switch (vetorDados[INDEX_TIPO_VEICULO]) {
            case "app.veiculo.Carro" -> "app.veiculo.Carro";
            case "app.veiculo.Furgao" -> "app.veiculo.Furgao";
            case "app.veiculo.Van" -> "app.veiculo.Van";
            default -> "app.veiculo.Caminhao";
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


    //ordena a lista de veiculos disponivel
    private List<Veiculo> ordenar(String criterio) {
        List<Veiculo> listaVeiculosSortedRotas = new ArrayList<>(this.listaVeiculos);

        if ("Rotas".equals(criterio)) {
            listaVeiculosSortedRotas.sort(Comparator.comparing(Veiculo::getNumRotas).reversed());



            return listaVeiculosSortedRotas;
        }

        return null;
    }

    //método que calcula a km media de rotas
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
        List<Veiculo> listaVeiculosSortedRotas = ordenar("Rotas");

       if(listaVeiculosSortedRotas != null) {
           return (ArrayList<Veiculo>) listaVeiculosSortedRotas
                   .stream()
                   .limit(3)
                   .collect(Collectors.toList());
       }

       return null;
    }

    /* ordenação dos custos de app.veiculo em ordem decrescente */
    public void ordenarCustoDecrescentes() {
        Collections.sort(listaVeiculos);
        System.out.println(listaVeiculos);
    }

    /* filtrar as rotas por data */
    public void rotasPorData(Date data) {
        for (Veiculo veiculo : listaVeiculos) {
            for (Rota rota : veiculo.listaRotas) {
                if (rota.getData().equals(data))
                    System.out.println(rota);
            }
        }
    }
}
