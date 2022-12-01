public class FabricaFurgao implements IFabrica {
    //implementação fábrica para cada veiculo - FURGAO
    public Veiculo criar(double preco, String placa) {
        return new Furgao(preco, placa);
    }
}
