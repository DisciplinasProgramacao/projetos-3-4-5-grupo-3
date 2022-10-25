public class Van extends Veiculo {
    private static final double VALOR_ALINHAMENTO = 120;
    private static final double VALOR_VISTORIA = 500;
    private static final double CAPACIDADE_TANQUE = 60;
    private static final double TAXA_IPVA = 0.03;
    private static final double TAXA_SEGURO = 0.03;
    private static final double KM_NECESSARIO_VISTORIA= 10000;

    public Van(double valorVeiculo, double quilometragremMedia) {
        super(valorVeiculo, quilometragremMedia, CAPACIDADE_TANQUE, TAXA_IPVA,TAXA_SEGURO);
    }

    @Override
    protected double getOutrosCustos() {
        return VALOR_ALINHAMENTO * retornaAcadaXMilQuilometros(KM_NECESSARIO_VISTORIA) + VALOR_VISTORIA * retornaAcadaXMilQuilometros(KM_NECESSARIO_VISTORIA);
    }

    @Override
    public double getPrecoSeguro() {
        return taxaSeguro * valor;
    }
}
