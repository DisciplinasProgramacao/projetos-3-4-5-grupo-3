package app.veiculo;

import java.util.ArrayList;

public class Van extends Veiculo {

    //atributos
    private static final String TIPO = "app.veiculo.Van";
    public static final double CAPACIDADE_TANQUE = 60;
    private static final double TAXA_IPVA = 0.03;
    private static final double TAXA_SEGURO = 0.03;

    //arraylist com os tipos de combustiveis válidos para van
    private static final ArrayList<Combustivel> TIPOS_COMBUSTIVEL = new ArrayList<>() {
        {
            add(Combustivel.GASOLINA);
            add(Combustivel.DIESEL);
        }
    };


    public Van(double valorVeiculo, String placa) throws Exception {
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


    //get
    public static double getCapacidadeTanque() {
        return CAPACIDADE_TANQUE;
    }
}
