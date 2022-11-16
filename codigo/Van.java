public class Van extends Veiculo {
    private static final String TIPO = "Van";
    public static final double CAPACIDADE_TANQUE = 60;
    private static final double TAXA_IPVA = 0.03;
    private static final double TAXA_SEGURO = 0.03;


    public Van(double valorVeiculo, String placa) {
        super(TIPO, placa, valorVeiculo, CAPACIDADE_TANQUE, TAXA_IPVA, TAXA_SEGURO,Combustivel.GASOLINA);
    }


    public static double getCapacidadeTanque() {
        return CAPACIDADE_TANQUE;
    }
}
