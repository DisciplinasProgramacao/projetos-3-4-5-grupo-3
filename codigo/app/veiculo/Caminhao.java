package app.veiculo;

import java.util.ArrayList;

public class Caminhao extends Veiculo {
    private static final String TIPO = "app.veiculo.Caminhao";
    private static final double CAPACIDADE_TANQUE = 250;
    private static final double TAXA_IPVA = 0.01;
    private static final double TAXA_SEGURO = 0.02;
    private static final double TAXA_EXTRA_SEGURO = 2000;
    private static final ArrayList<Combustivel> TIPOS_COMBUSTIVEL = new ArrayList<>() {
        {
            add(Combustivel.GASOLINA);
        }
    };


    public Caminhao(double valorVeiculo, String placa) throws Exception {
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

    @Override
    public boolean adicionarGasto(String tipoGasto, double valorGasto) throws Exception {
        tipoGasto = tipoGasto.toLowerCase();
        if(tipoGasto.equals("vistoria"))
            throw new Exception("Tipo de gasto invalido para o caminhao");
        Gasto gasto = new Gasto(tipoGasto, valorGasto);
        gastos.add(gasto);
        return false;
    }
}
