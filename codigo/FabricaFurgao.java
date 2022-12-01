public class FabricaFurgao implements IFabrica {

    public Veiculo criar(double preco, String placa) {
        return new Furgao(preco, placa);
    }
}
