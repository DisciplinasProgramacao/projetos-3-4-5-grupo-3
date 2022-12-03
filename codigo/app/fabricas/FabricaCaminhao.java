package app.fabricas;

import app.veiculo.Caminhao;
import app.veiculo.Veiculo;

public class FabricaCaminhao implements IFabrica {

    public Veiculo criar(double preco, String placa) throws Exception {
        return new Caminhao(preco, placa);
    }

}
