import java.io.IOException;
import java.util.Scanner;


public class Main {


    private static Frota frota;
    public static String nomeDoAquivo = "codigo/arquivoCarro.txt";

    public static void main(String[] args) throws IOException {
        frota = new Frota();
        printaMenu();
    }

    private static void menuEscolha(int escolha) throws IOException {
        switch (escolha) {
            case 1 -> carregarVeiculo();
            case 2 -> salvarVeiculos();
            case 3 -> incluirVeiculo();
            case 4 -> incluirRotaVeiculo();
            case 5 -> localizarVeiculo();
            case 6 -> imprimeRelatorio();
            case 7 -> mediaTodasAsRotas();
            case 0 -> System.out.println("Obrigado Por Utilizar :)");
            default -> System.out.println("Opcao Invalida");
        }
    }

    private static void mediaTodasAsRotas() {
        frota.kmMediaDasRotas();
    }


    private static void carregarVeiculo() throws IOException {
        String nomeDoAquivo = "codigo/arquivoCarro.txt";
        frota.carregar(nomeDoAquivo);
    }

    private static void printaMenu() throws IOException {
        Scanner teclado = new Scanner(System.in);
        int escolha = 61;
        while (escolha != 0) {
            System.out.println("------MENU------\nEscolha uma opção: ");
            System.out.println("[1] -> Carregar um conjunto de veículos de um arquivo ");
            System.out.println("[2] -> Salvar um conjunto de veículos de um arquivo");
            System.out.println("[3] -> Incluir um novo veículo");
            System.out.println("[4] -> Incluir rotas para um veículo");
            System.out.println("[5] -> Localizar um veículo da frota");
            System.out.println("[6] -> Imprimir um relatório do veículo com seus gastos até o momento");
            System.out.println("[7] -> Imprimir a Quilometragem média de todas as rotas da empresa ");
            System.out.println("[0] -> Sair do Menu");
            escolha = teclado.nextInt();
            menuEscolha(escolha);
        }
    }

    private static void salvarVeiculos() throws IOException {
        frota.salvar(nomeDoAquivo);
    }

    private static void incluirVeiculo() {
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
            System.out.println("O veiculo não existe na frota");
        else System.out.println("O veiculo existe na rota");
    }

    private static void imprimeRelatorio() {
        Veiculo veiculoProcurar = frota.procurar(perguntaPlaca());
        if (veiculoProcurar == null)
            System.out.println("O veiculo não existe na rota");
        else System.out.println(veiculoProcurar);
    }

    private static String perguntaPlaca() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a placa do veiculo");
        return teclado.next();
    }

}
