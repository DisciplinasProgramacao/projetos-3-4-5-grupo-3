public class Carro extends Veiculo {
    
    private static final double VALOR_ALINHAMENTO = 80;

    public Carro(double valorVeiculo, double quilometragremMedia) {
        super(valorVeiculo, quilometragremMedia, 50, 0.04, 0.05);
    }

    @Override
    protected double getOutrosCustos() {
        return VALOR_ALINHAMENTO * retornaAcadaXMilQuilometros(10000);
    }

    @Override
    public double getPrecoSeguro() {
        return taxaSeguro * valor + 300;
    }
}
