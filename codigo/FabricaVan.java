public class FabricaVan implements IFabrica {

    public Veiculo criar(double preco, String placa) {
        return new Van(preco, placa);
    }

}
