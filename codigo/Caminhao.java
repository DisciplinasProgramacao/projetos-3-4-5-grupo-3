public class Caminhao extends Veiculo {
    private static final String tipo = "Caminhao";
    private static final double VALOR_MANUTENCAO = 1000;
    private static final double VALOR_VISTORIA = 1000;
    private static final double CAPACIDADE_TANQUE = 250;
    private static final double TAXA_IPVA = 0.01;
    private static final double TAXA_SEGURO = 0.02;
    private static final double KM_NECESSARIO_MANUTENCAO = 20000;
    private static final double KM_NECESSARIO_VISTORIA = 30000;
    private static final double TAXA_EXTRA_SEGURO = 2000;

    public Caminhao(double valorVeiculo,String placa,  double quilometragremMedia) {
        super(tipo,placa, valorVeiculo, quilometragremMedia, CAPACIDADE_TANQUE, TAXA_IPVA, TAXA_SEGURO);
    }

    @Override
    protected double getOutrosCustos() {
        return VALOR_MANUTENCAO * quantidadeServicoKMTotal(KM_NECESSARIO_MANUTENCAO) + VALOR_VISTORIA * quantidadeServicoKMTotal(KM_NECESSARIO_VISTORIA);
    }

    @Override
    public double calcularSeguro() {
        return taxaSeguro * valor + TAXA_EXTRA_SEGURO;
    }

    public static double getCapacidadeTanque() {
        return CAPACIDADE_TANQUE;
    }
}
