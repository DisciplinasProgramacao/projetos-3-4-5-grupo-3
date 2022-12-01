import java.util.ArrayList;

public class Caminhao extends Veiculo {
    private static final String TIPO = "Caminhao";
    private static final double CAPACIDADE_TANQUE = 250;
    private static final double TAXA_IPVA = 0.01;
    private static final double TAXA_SEGURO = 0.02;
    private static final double TAXA_EXTRA_SEGURO = 2000;
    private static final ArrayList<String> TIPOS_COMBUSTIVEL = new ArrayList<>() {
        {
            add("Diesel");
        }
    };


    public Caminhao(double valorVeiculo, String placa) {
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


    @Override
    public double calcularSeguro() {
        return taxaSeguro * valor + TAXA_EXTRA_SEGURO;
    }

    public static double getCapacidadeTanque() {
        return CAPACIDADE_TANQUE;
    }
}
