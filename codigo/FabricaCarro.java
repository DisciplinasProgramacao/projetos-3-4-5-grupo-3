public class FabricaCarro implements IFabrica {
    //implementação fábrica para cada veiculo - CAMINHAO
    public Veiculo criar(double preco, String placa) throws Exception {
        return new Carro(preco, placa);
    }

}
