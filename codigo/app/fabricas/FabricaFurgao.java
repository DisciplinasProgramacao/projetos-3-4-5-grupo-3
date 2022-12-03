package app.fabricas;

import app.veiculo.Furgao;
import app.veiculo.Veiculo;

public class FabricaFurgao implements IFabrica {
    //implementação fábrica para cada app.veiculo - FURGAO
    public Veiculo criar(double preco, String placa) throws Exception {
        return new Furgao(preco, placa);
    }
}
