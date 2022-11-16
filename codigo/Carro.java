public class Carro extends Veiculo {
    //#region Atributos
    private static final String TIPO = "Carro";
    private static final double CAPACIDADE_TANQUE = 50;
    private static final double TAXA_IPVA = 0.04;
    private static final double TAXA_SEGURO = 0.05;
    private static final double TAXA_EXTRA_SEGURO = 300;

    //#endregion
    //#region Construtor
    public Carro(double valorVeiculo, String placa) {
        super(TIPO, placa, valorVeiculo,  CAPACIDADE_TANQUE, TAXA_IPVA, TAXA_SEGURO,Combustivel.GASOLINA);
    }

    //#endregion
    //#region Métodos


    @Override
    public double calcularSeguro() {
        return taxaSeguro * valor + TAXA_EXTRA_SEGURO;
    }
    //#endregion
    public static double getCapacidadeTanque() {
        return CAPACIDADE_TANQUE;
    }
}
