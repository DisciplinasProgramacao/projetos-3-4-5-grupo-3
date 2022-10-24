public class Caminhao extends Veiculo {
    
    private static final double VALOR_MANUTENCAO = 1000;
    private static final double VALOR_VISTORIA = 1000;

    Caminhao(double valorVeiculo, double quilometragremMedia) {
        super(valorVeiculo, quilometragremMedia, 250, 0.01, 0.02);
    }

    @Override
    protected double calcularSeguro() {
        return (this.taxaSeguro * valor) + 2000;
    }

    @Override
    protected double getOutrosCustos() {
        return VALOR_MANUTENCAO * retornaAcadaXMilQuilometros(20000) + VALOR_VISTORIA * retornaAcadaXMilQuilometros(30000);
    }

    @Override
    public double getPrecoSeguro() {
        return taxaSeguro * valor + 200;
    }
}
