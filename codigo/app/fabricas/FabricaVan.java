package app.fabricas;

import app.veiculo.Van;
import app.veiculo.Veiculo;

public class FabricaVan implements IFabrica {
//implementação fábrica para cada app.veiculo - VAN
    public Veiculo criar(double preco, String placa) throws Exception {
        return new Van(preco, placa);
    }

}
