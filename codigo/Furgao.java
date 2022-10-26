public class Furgao extends Veiculo {
    
    private static final double VALOR_ALINHAMENTO = 120;
    private static final double VALOR_VISTORIA = 500;
    private static final double CAPACIDADE_TANQUE = 80;
    private static final double TAXA_IPVA = 0.03;
    private static final double TAXA_SEGURO = 0.03;
    private static final double KM_NECESSARIO_VISTORIA= 10000;
    public Furgao(double valorVeiculo, double quilometragremMedia) {
        super(valorVeiculo, quilometragremMedia, CAPACIDADE_TANQUE, TAXA_IPVA,TAXA_SEGURO);
    }

    @Override
    protected double getOutrosCustos() {
        return VALOR_ALINHAMENTO * quantidadeServicoKMTotal(KM_NECESSARIO_VISTORIA) + VALOR_VISTORIA * quantidadeServicoKMTotal(KM_NECESSARIO_VISTORIA);
    }

    public static double getCapacidadeTanque() {
        return CAPACIDADE_TANQUE;
    }
}
