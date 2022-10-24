public class Caminhao extends Veiculo {
    private static final double CAPACIDADE_TANQUE = 250;
    private static final double TAXA_IPVA = 0.01;
    private static final double TAXA_SEGURO = 0.02;
    private static final double VALOR_MANUTENCAO = 1000;
    private static final double VALOR_VISTORIA = 1000;

    Caminhao(double valorVeiculo, double quilometragremMedia) {
        super(valorVeiculo, quilometragremMedia, CAPACIDADE_TANQUE, TAXA_IPVA, TAXA_SEGURO);
    }

    @Override
    protected double calcularSeguro() {
        return (TAXA_SEGURO * valor) + 2000;
    }

    @Override
    protected double calcularOutrosCustos() {
        return VALOR_MANUTENCAO * retornaAcadaXMilQuilometros(20000) + VALOR_VISTORIA * retornaAcadaXMilQuilometros(30000);
    }
}
