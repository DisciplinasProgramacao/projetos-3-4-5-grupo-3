public class Van extends Veiculo {
    private static final double VALOR_ALINHAMENTO = 120;
    private static final double VALOR_VISTORIA = 500;

    public Van(double valorVeiculo, double quilometragremMedia) {
        super(valorVeiculo, quilometragremMedia, 60, 0.03, 0.03);
    }

    @Override
    protected double getOutrosCustos() {
        return VALOR_ALINHAMENTO * retornaAcadaXMilQuilometros(10000) + VALOR_VISTORIA * retornaAcadaXMilQuilometros(10000);
    }

    @Override
    public double getPrecoSeguro() {
        return taxaSeguro * valor;
    }
}
