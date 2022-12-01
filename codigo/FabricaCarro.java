public class FabricaCarro implements IFabrica {

    public Veiculo criar(double preco, String placa) {
        return new Carro(preco, placa);
    }

}
