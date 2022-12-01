public class FabricaCaminhao implements IFabrica {

    public Veiculo criar(double preco, String placa) {
        return new Caminhao(preco, placa);
    }

}
