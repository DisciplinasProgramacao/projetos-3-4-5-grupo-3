package app.fabricas;

import app.veiculo.*;

public class FabricaVeiculo {
    /* Fábrica genérica que engloba a criação de um app.veiculo qualquer*/
    public static void criarVeiculo(String tipo, double preco, String placa) throws Exception {
        switch (tipo) {
            case "app.veiculo.Caminhao" -> new Caminhao(preco, placa);

            case "app.veiculo.Carro" -> new Carro(preco, placa);

            case "app.veiculo.Furgao" -> new Furgao(preco, placa);

            case "app.veiculo.Van" -> new Van(preco, placa);

            default -> throw new Exception("Tipo inexistente");

        }
    }
}
