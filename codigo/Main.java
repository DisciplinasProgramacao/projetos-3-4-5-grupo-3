import java.io.IOException;
import java.util.Scanner;


public class Main {


    private static  Frota frota;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

       frota = new Frota();
       printaMenu();
    }

    private static void menuEscolha(int escolha) throws IOException, ClassNotFoundException {

        switch (escolha) {
            case 1 -> carregarVeiculo();
            case 2 -> salvarVeiculos();
            case 3 -> incluirVeiculo();
            case 4 -> incluirRotaVeiculo();
            case 5 -> localizarVeiculo();
            case 6 -> imprimeRelatorio();
            case 0 -> System.out.println("Obrigado Por Utilizar :)");
            default -> System.out.println("Opcao Invalida");
        }
    }


    private static void carregarVeiculo() throws ClassNotFoundException, IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo de onde será carregada a frota: ");
        String nomeDoAquivo = teclado.nextLine();
        frota.carregar(nomeDoAquivo);
    }

    private static void  printaMenu() throws IOException, ClassNotFoundException {
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
            System.out.println("[0] -> Sair do Menu");
            escolha = teclado.nextInt();
            menuEscolha(escolha);
        }
    }

    private static void salvarVeiculos() throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo onde a frota será salva: ");
        String nomeDoAquivo = teclado.nextLine();
        frota.salvar(nomeDoAquivo);
        teclado.close();
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
        String placa = teclado.next();
        return placa;
    }

//    public static void inserirVeiculo() {
//        Scanner teclado = new Scanner(System.in);
//        int escolhaVeiculo = 1;
//        while (escolhaVeiculo > 0 && escolhaVeiculo <= 4) {
//            System.out.println("Escolha qual tipo de veículo você deseja inserir:\n" +
//                    "[1] -> Carro\n" +
//                    "[2] -> Van\n" +
//                    "[3] -> Furgão\n" +
//                    "[4] -> Caminhão\n" +
//                    "[0] -> Sair do menu");
//            escolhaVeiculo = teclado.nextInt();
//            switch (escolhaVeiculo) {
//                case 1:
//                    System.out.println("Informe o valor da venda: ");
//                    double valorVendaCarro = teclado.nextDouble();
//                    System.out.println("Informe a quilometragem média: ");
//                    double quilometragemMediaCarro = teclado.nextDouble();
//                    System.out.println("Informe a placa do carro:");
//                    String placaCarro = teclado.nextLine();
//                    Veiculo novoCarro = new Carro(valorVendaCarro, placaCarro, quilometragemMediaCarro);
//                    System.out.println("Valor da venda -> " + valorVendaCarro + "Quilometragem Média -> " + quilometragemMediaCarro
//                            + "Capacidade do tanque -> " + Carro.getCapacidadeTanque());
//                    break;
//                case 2:
//                    System.out.println("Informe o valor da venda: ");
//                    double valorVendaVan = teclado.nextDouble();
//                    System.out.println("Informe a quilometragem média: ");
//                    double quilometragemMediaVan = teclado.nextDouble();
//                    System.out.println("Informe a placa da van:");
//                    String placaVan = teclado.nextLine();
//                    Veiculo novoVan = new Van(valorVendaVan, placaVan, quilometragemMediaVan);
//                    System.out.println("Placa -> " + placaVan + "\nValor da venda -> " + valorVendaVan + "\nQuilometragem Média -> " + quilometragemMediaVan
//                            + "\nCapacidade do tanque -> " + Van.getCapacidadeTanque());
//                    break;
//                case 3:
//                    System.out.println("Informe o valor da venda: ");
//                    double valorVendaFurgao = teclado.nextDouble();
//                    System.out.println("Informe a quilometragem média: ");
//                    double quilometragemMediaFurgao = teclado.nextDouble();
//                    System.out.println("Informe a placa do carro:");
//                    String placaFurgao = teclado.nextLine();
//                    Veiculo novoFurgao = new Furgao(valorVendaFurgao, placaFurgao, quilometragemMediaFurgao);
//                    System.out.println("Placa -> " + placaFurgao + "\nValor da venda -> " + valorVendaFurgao + "\nQuilometragem Média -> " + quilometragemMediaFurgao
//                            + "\nCapacidade do tanque -> " + Furgao.getCapacidadeTanque());
//                    break;
//                case 4:
//                    System.out.println("Informe o valor da venda: ");
//                    double valorVendaCaminhao = teclado.nextDouble();
//                    System.out.println("Informe a quilometragem média: ");
//                    double quilometragemMediaCaminhao = teclado.nextDouble();
//                    System.out.println("Informe a placa do caminhão:");
//                    String placaCaminhao = teclado.nextLine();
//                    Veiculo novoCaminhao = new Caminhao(valorVendaCaminhao, placaCaminhao, quilometragemMediaCaminhao);
//                    System.out.println("Placa -> " + placaCaminhao + "\nValor da venda -> " + valorVendaCaminhao + "\nQuilometragem Média -> " + quilometragemMediaCaminhao
//                            + "\nCapacidade do tanque -> " + Caminhao.getCapacidadeTanque());
//                    break;
//
//            }
//        }
//    }

}
