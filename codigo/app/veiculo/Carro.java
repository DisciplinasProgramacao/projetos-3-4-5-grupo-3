package app.veiculo;

import java.util.ArrayList;

public class Carro extends Veiculo {
    //#region Atributos
    private static final String TIPO = "app.veiculo.Carro";
    private static final double CAPACIDADE_TANQUE = 50;
    private static final double TAXA_IPVA = 0.04;
    private static final double TAXA_SEGURO = 0.05;
    private static final double TAXA_EXTRA_SEGURO = 300;
    private static final ArrayList<Combustivel> TIPOS_COMBUSTIVEL = new ArrayList<>() {
        {
            add(Combustivel.GASOLINA);
        }
    };


    public Carro(double valorVeiculo, String placa) throws Exception {
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

    @Override
    public boolean adicionarGasto(String tipoGasto, double valorGasto) throws Exception {
        tipoGasto = tipoGasto.toLowerCase();
        if(tipoGasto.equals("vistoria")) {
            throw new Exception("Tipo de gasto invalido para o carro");
        }
        Gasto gasto = new Gasto(tipoGasto, valorGasto);
        gastos.add(gasto);
        return true;
    }
}
