public class FabricaVan implements IFabrica {
//implementação fábrica para cada veiculo - VAN
    public Veiculo criar(double preco, String placa) throws Exception {
        return new Van(preco, placa);
    }

}
