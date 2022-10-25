import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int escolha = 1;
        while (escolha!=0) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("------MENU------");
            System.out.println("Escolha uma opção: ");
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

            }
        }
    }

    private static void carregarArquivo() {
        String arquivo = "/Users/Matheus/Desktop/PUC 2022.2/LaboratorioModular/Veiculos.txt";
        String txt = Arquivo.Read(arquivo);
        if (txt.isEmpty()) {
            System.out.println("Não existe nenhum veículo cadastrado");
        } else {
            System.out.println(txt);
        }
    }

}