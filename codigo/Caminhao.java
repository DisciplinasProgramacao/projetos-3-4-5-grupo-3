public class Caminhao extends Veiculo {
    private static final String tipo = "Caminhao";
    private static final double CAPACIDADE_TANQUE = 250;
    private static final double TAXA_IPVA = 0.01;
    private static final double TAXA_SEGURO = 0.02;
    private static final double TAXA_EXTRA_SEGURO = 2000;

    public Caminhao(double valorVeiculo,String placa) {
        super(tipo,placa, valorVeiculo, CAPACIDADE_TANQUE, TAXA_IPVA, TAXA_SEGURO,Combustivel.DIESEL);
    }



    @Override
    public double calcularSeguro() {
        return taxaSeguro * valor + TAXA_EXTRA_SEGURO;
    }

    public static double getCapacidadeTanque() {
        return CAPACIDADE_TANQUE;
    }
}
