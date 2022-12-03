package app.fabricas;

import app.veiculo.Carro;
import app.veiculo.Veiculo;

public class FabricaCarro implements IFabrica {
    //implementação fábrica para cada app.veiculo - CAMINHAO
    public Veiculo criar(double preco, String placa) throws Exception {
        return new Carro(preco, placa);
    }

}
