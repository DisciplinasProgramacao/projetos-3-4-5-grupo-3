public class Van extends Veiculo {
    private static final String TIPO = "Van";
    private static final double VALOR_ALINHAMENTO = 120;
    private static final double VALOR_VISTORIA = 500;
    public static final double CAPACIDADE_TANQUE = 60;
    private static final double TAXA_IPVA = 0.03;
    private static final double TAXA_SEGURO = 0.03;
    private static final double KM_NECESSARIO_VISTORIA = 10000;

    public Van(double valorVeiculo,String placa, double quilometragremMedia) {
        super(TIPO,placa, valorVeiculo, quilometragremMedia, CAPACIDADE_TANQUE, TAXA_IPVA, TAXA_SEGURO);
    }

    @Override
    protected double getOutrosCustos() {
        return VALOR_ALINHAMENTO * quantidadeServicoKMTotal(KM_NECESSARIO_VISTORIA) + VALOR_VISTORIA * quantidadeServicoKMTotal(KM_NECESSARIO_VISTORIA);
    }

    public static double getCapacidadeTanque() {
        return CAPACIDADE_TANQUE;
    }
}
