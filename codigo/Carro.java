public class Carro extends Veiculo {
    
    private static final double VALOR_ALINHAMENTO = 80;
    private static final double CAPACIDADE_TANQUE = 50;
    private static final double TAXA_IPVA = 0.04;
    private static final double TAXA_SEGURO = 0.05;
    private static final double KM_NECESSARIO_VISTORIA= 10000;

    public Carro(double valorVeiculo, double quilometragremMedia) {
        super(valorVeiculo, quilometragremMedia, CAPACIDADE_TANQUE,TAXA_IPVA, TAXA_SEGURO);
    }

    @Override
    protected double getOutrosCustos() {
        return VALOR_ALINHAMENTO * retornaAcadaXMilQuilometros(KM_NECESSARIO_VISTORIA);
    }

    @Override
    public double getPrecoSeguro() {
        return taxaSeguro * valor + 300;
    }
}
