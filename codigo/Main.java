import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        int escolha = 1;
        while (escolha!=0) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("------MENU------\nEscolha uma opção: ");
            System.out.println("[1] -> Carregar um conjunto de veículos de um arquivo ");
            System.out.println("[2] -> Salvar um conjunto de veículos de um arquivo");
            System.out.println("[3] -> Incluir um novo veículo");
            System.out.println("[4] -> Incluir rotas para um veículo");
            System.out.println("[5] -> Localizar um veículo da frota");
            System.out.println("[6] -> Imprimir um relatório do veículo com seus gastos até o momento");
            System.out.println("[0] -> Sair do Menu");
            escolha = teclado.nextInt();
            switch (escolha) {
                case 1:
                    carregarArquivo();
                    break;

                case 2:
                    System.out.println("oi");
                    break;
                case 3:
                    inserirVeiculo();
                    break;


            }
        }
    }

    public static void carregarArquivo() {
        String arquivo = "/Users/Matheus/Desktop/PUC 2022.2/LaboratorioModular/Veiculos.txt";
        String txt = Arquivo.Read(arquivo);
        if (txt.isEmpty()) {
            System.out.println("Não existe nenhum veículo cadastrado");
        } else {
            System.out.println(txt);
        }
    }

    public static void inserirVeiculo() {
        Scanner teclado = new Scanner(System.in);
        int escolhaVeiculo = 1;
        while (escolhaVeiculo > 0 && escolhaVeiculo <= 4) {
            System.out.println("Escolha qual tipo de veículo você deseja inserir:\n" +
                    "[1] -> Carro\n" +
                    "[2] -> Van\n" +
                    "[3] -> Furgão\n" +
                    "[4] -> Caminhão\n"+
                    "[0] -> Sair do menu");
            escolhaVeiculo = teclado.nextInt();
            switch (escolhaVeiculo) {
                case 1:
                    System.out.println("Informe o valor da venda: ");
                    double valorVendaCarro = teclado.nextDouble();
                    System.out.println("Informe a quilometragem média: ");
                    double quilometragemMediaCarro = teclado.nextDouble();
                    Veiculo novoCarro = new Carro(valorVendaCarro, quilometragemMediaCarro);
                    System.out.println("Valor da venda -> " + valorVendaCarro + "Quilometragem Média -> " + quilometragemMediaCarro
                            + "Capacidade do tanque -> " + Carro.getCapacidadeTanque());
                    break;
                case 2:
                    System.out.println("Informe o valor da venda: ");
                    double valorVendaVan = teclado.nextDouble();
                    System.out.println("Informe a quilometragem média: ");
                    double quilometragemMediaVan = teclado.nextDouble();
                    Veiculo novoVan = new Van(valorVendaVan, quilometragemMediaVan);
                    System.out.println("Valor da venda -> " + valorVendaVan + "Quilometragem Média -> " + quilometragemMediaVan
                            + "Capacidade do tanque -> " + Van.getCapacidadeTanque());
                    break;
                case 3:
                    System.out.println("Informe o valor da venda: ");
                    double valorVendaFurgao = teclado.nextDouble();
                    System.out.println("Informe a quilometragem média: ");
                    double quilometragemMediaFurgao = teclado.nextDouble();
                    Veiculo novoFurgao = new Furgao(valorVendaFurgao, quilometragemMediaFurgao);
                    System.out.println("Valor da venda -> " + valorVendaFurgao + "Quilometragem Média -> " + quilometragemMediaFurgao
                            + "Capacidade do tanque -> " + Furgao.getCapacidadeTanque());
                    break;
                case 4:
                    System.out.println("Informe o valor da venda: ");
                    double valorVendaCaminhao = teclado.nextDouble();
                    System.out.println("Informe a quilometragem média: ");
                    double quilometragemMediaCaminhao = teclado.nextDouble();
                    Veiculo novoCaminhao = new Caminhao(valorVendaCaminhao, quilometragemMediaCaminhao);
                    System.out.println("Valor da venda -> " + valorVendaCaminhao + "Quilometragem Média -> " + quilometragemMediaCaminhao
                            + "Capacidade do tanque -> " + Caminhao.getCapacidadeTanque());
                    break;

            }
        }
    }

    /*public static void inserirRota(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Forneça a data da rota: ");
        Date data = teclado.nextLine();
        System.out.println("Insira a distância da rota:");
        double distancia = teclado.nextDouble();
        Rota novaRota = new Rota(data, distancia);
        Veiculo.addRota(novaRota);

    } */
}
