public class FabricaCarro implements IFabrica {
    //implementação fábrica para cada veiculo - CAMINHAO
    public Veiculo criar(double preco, String placa) {
        return new Carro(preco, placa);
    }

}
