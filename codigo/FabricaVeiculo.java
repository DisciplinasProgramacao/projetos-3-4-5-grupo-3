public class FabricaVeiculo {
    static Veiculo criarVeiculo(String tipo, double preco, String placa) throws Exception {
        switch (tipo) {
            case "Caminhao" -> {
                return new Caminhao(preco, placa);
            }

            case "Carro" -> {
                return new Carro(preco, placa);
            }

            case "Furgao" -> {
                return new Furgao(preco, placa);
            }

            case "Van" -> {
                return new Van(preco, placa);
            }

            default -> throw new Exception("Tipo inexistente");

        }
    }
}
