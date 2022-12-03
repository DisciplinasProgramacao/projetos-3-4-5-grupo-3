package app;

import app.veiculo.Frota;
import app.veiculo.Rota;
import app.veiculo.Veiculo;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;


public class Main {


    private static Frota frota;
    public static String nomeDoAquivo = "codigo/arquivoCarro.txt";

    public static void main(String[] args) throws Exception {
        frota = new Frota();
        printaMenu();
    }

    /* metodo para fornecer o menu */
    private static void menuEscolha(int escolha) throws Exception {
        switch (escolha) {
            case 1 -> carregarVeiculo();
            case 2 -> salvarVeiculos();
            case 3 -> incluirVeiculo();
            case 4 -> incluirRotaVeiculo();
            case 5 -> localizarVeiculo();
            case 6 -> adicionarGasto();
            case 7 -> imprimeRelatorio();
            case 8 -> mediaTodasAsRotas();
            case 9 -> listaOrdenadaGastos();
            case 10 -> veiculosMaisRotas();
            case 11 -> buscaRotaPorData();
            case 0 -> System.out.println("Obrigado Por Utilizar :)");
            default -> System.out.println("Opcao Invalida");
        }
    }

    /* método que procura um percurso pela data fornecida pelo usuario */
    private static void buscaRotaPorData() {

        System.out.println("Digite a data");
        Scanner teclado = new Scanner(System.in);
        Date data = new Date(teclado.nextLine());
        frota.rotasPorData(data);
    }

    private static void veiculosMaisRotas() {
        System.out.println(frota.maisRotas());
    }

    /* método para adicionar gasto em determinado app.veiculo */
    private static void adicionarGasto() {
        Veiculo veiculo = frota.procurar(perguntaPlaca());
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do gasto");
        String nomeGasto = teclado.nextLine();
        System.out.println("Digite o valor do gasto");
        double valorGasto = teclado.nextDouble();
        veiculo.adicionarGasto(nomeGasto, valorGasto);
    }

    /* método para ordenar os gastos de forma decrescente */
    private static void listaOrdenadaGastos() {
        frota.ordenarCustoDecrescentes();
    }

    /* fornece a km média de todas as rotas já feitas */
    private static void mediaTodasAsRotas() {

        frota.kmMediaDasRotas();
    }


    /* lê o arquivo e carrega o mesmo */
    private static void carregarVeiculo() throws Exception {
        String nomeDoAquivo = "codigo/arquivoCarro.txt";
        frota.carregar(nomeDoAquivo);
    }

    private static void printaMenu() throws Exception {
        Scanner teclado = new Scanner(System.in);
        int escolha = 61;
        while (escolha != 0) {
            System.out.println("------MENU------\nEscolha uma opção: ");
            System.out.println("[1] -> Carregar um conjunto de veículos de um arquivo ");
            System.out.println("[2] -> Salvar um conjunto de veículos de um arquivo");
            System.out.println("[3] -> Incluir um novo veículo");
            System.out.println("[4] -> Incluir rotas para um veículo");
            System.out.println("[5] -> Localizar um veículo da frota");
            System.out.println("[6] -> Incluir gasto ao app.veiculo");
            System.out.println("[7] -> Imprimir um relatório do veículo com seus gastos até o momento");
            System.out.println("[8] -> Imprimir a Quilometragem média de todas as rotas da empresa ");
            System.out.println("[9] -> Imprimir a lista de veiculos ordenadas por gasto");
            System.out.println("[10] -> Imprimir a lista de veiculos com mais rotas");
            System.out.println("[0] -> Sair do Menu");
            escolha = teclado.nextInt();
            menuEscolha(escolha);
        }
    }

    /* métodos útilizados para manuseio dos veiculos
        * incluir
        * salvar
        * incluir rota
        * localizar app.veiculo
        * imprimir relatorio
     */
    private static void salvarVeiculos() throws IOException {
        frota.salvar(nomeDoAquivo);
    }

    private static void incluirVeiculo() throws Exception {
        System.out.println("Insira os dados no formato Tipo;Placa;PRECO;KM MEDIA");
        Scanner teclado = new Scanner(System.in);
        String dadosCarroInserir = teclado.nextLine();
        frota.insereNaFrota(dadosCarroInserir);
        teclado.close();
    }

    private static void incluirRotaVeiculo() {
        Scanner teclado = new Scanner(System.in);
        Veiculo veiculo = frota.procurar(perguntaPlaca());
        System.out.println("Digite a data da rota");
        String data = teclado.nextLine();
        System.out.println("Digite a distância da rota");
        double distancia = teclado.nextDouble();
        Rota rota = new Rota(data, distancia);
        veiculo.addRota(rota);
    }

    private static void localizarVeiculo() {
        Veiculo veiculoProcurado = frota.procurar(perguntaPlaca());
        if (veiculoProcurado == null)
            System.out.println("O app.veiculo não existe na frota");
    }

    private static void imprimeRelatorio() {
        Veiculo veiculoProcurar = frota.procurar(perguntaPlaca());
        if (veiculoProcurar == null)
            System.out.println("O app.veiculo não existe na rota");
        else System.out.println(veiculoProcurar);
    }

    private static String perguntaPlaca() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a placa do app.veiculo");
        return teclado.next();
    }
}
