import java.util.ArrayList;

public class Van extends Veiculo {
    private static final String TIPO = "Van";
    public static final double CAPACIDADE_TANQUE = 60;
    private static final double TAXA_IPVA = 0.03;
    private static final double TAXA_SEGURO = 0.03;
    private static final ArrayList<String> TIPOS_COMBUSTIVEL = new ArrayList<>() {
        {
            add("Gasolina");
            add("Diesel");
        }
    };


    public Van(double valorVeiculo, String placa) {
        super(
                TIPO,
                placa,
                valorVeiculo,
                CAPACIDADE_TANQUE,
                TAXA_IPVA,
                TAXA_SEGURO,
                Combustivel.GASOLINA,
                TIPOS_COMBUSTIVEL
        );
    }


    public static double getCapacidadeTanque() {
        return CAPACIDADE_TANQUE;
    }
}
