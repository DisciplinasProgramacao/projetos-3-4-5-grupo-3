import java.util.ArrayList;

public class Furgao extends Veiculo {
    /* region #Attributes */
    private static final String TIPO = "Furgao";
    private static final double CAPACIDADE_TANQUE = 80;
    private static final double TAXA_IPVA = 0.03;
    private static final double TAXA_SEGURO = 0.03;
    private static final ArrayList<Combustivel> TIPOS_COMBUSTIVEL = new ArrayList<>() {
        {
            add(Combustivel.GASOLINA);
            add(Combustivel.DIESEL);
        }
    };


    public Furgao(double valorVeiculo, String placa) throws Exception {
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


    /* get */
    public static double getCapacidadeTanque() {
        return CAPACIDADE_TANQUE;
    }
}
