public class Caminhao extends Veiculo {
    
    private static final double VALOR_MANUTENCAO = 1000;
    private static final double VALOR_VISTORIA = 1000;
    private static final double CAPACIDADE_TANQUE = 250;
    private static final double TAXA_IPVA = 0.01;
    private static final double TAXA_SEGURO = 0.02;
    private static final double KM_NECESSARIO_MANUTENCAO= 20000;

    private static final double KM_NECESSARIO_VISTORIA= 30000;

    public Caminhao(double valorVeiculo, double quilometragremMedia) {
        super(valorVeiculo, quilometragremMedia, CAPACIDADE_TANQUE, TAXA_IPVA, TAXA_SEGURO);
    }
    
    @Override
    protected double getOutrosCustos() {
        return VALOR_MANUTENCAO * retornaAcadaXMilQuilometros(KM_NECESSARIO_MANUTENCAO) + VALOR_VISTORIA * retornaAcadaXMilQuilometros(KM_NECESSARIO_VISTORIA);
    }

    @Override
    public double getPrecoSeguro() {
        return taxaSeguro * valor + 2000;
    }
}
