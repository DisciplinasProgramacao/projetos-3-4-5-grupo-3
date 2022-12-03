public class FabricaFurgao implements IFabrica {
    //implementação fábrica para cada veiculo - FURGAO
    public Veiculo criar(double preco, String placa) throws Exception {
        return new Furgao(preco, placa);
    }
}
