public class Carro extends Veiculo {
    //#region Atributos
    private static final double VALOR_ALINHAMENTO = 80;
    private static final double CAPACIDADE_TANQUE = 50;
    private static final double TAXA_IPVA = 0.04;
    private static final double TAXA_SEGURO = 0.05;
    private static final double KM_NECESSARIO_VISTORIA = 10000;
    private static final double TAXA_EXTRA_SEGURO = 300;

    //#endregion
    //#region Construtor
    public Carro(double valorVeiculo, double quilometragremMedia) {
        super(valorVeiculo, quilometragremMedia, CAPACIDADE_TANQUE, TAXA_IPVA, TAXA_SEGURO);
    }

    //#endregion
    //#region Métodos
    @Override
    protected double getOutrosCustos() {
        return VALOR_ALINHAMENTO * quantidadeServicoKMTotal(KM_NECESSARIO_VISTORIA);
    }

    @Override
    public double calcularSeguro() {
        return taxaSeguro * valor + TAXA_EXTRA_SEGURO;
    }
    //#endregion
}
