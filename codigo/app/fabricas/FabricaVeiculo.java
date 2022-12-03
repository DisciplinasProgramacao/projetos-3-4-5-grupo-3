package app.fabricas;

import app.veiculo.*;

public class FabricaVeiculo {
    /* Fábrica genérica que engloba a criação de um app.veiculo qualquer*/
    static Veiculo criarVeiculo(String tipo, double preco, String placa) throws Exception {
        switch (tipo) {
            case "app.veiculo.Caminhao" -> {
                return new Caminhao(preco, placa);
            }

            case "app.veiculo.Carro" -> {
                return new Carro(preco, placa);
            }

            case "app.veiculo.Furgao" -> {
                return new Furgao(preco, placa);
            }

            case "app.veiculo.Van" -> {
                return new Van(preco, placa);
            }

            default -> throw new Exception("Tipo inexistente");

        }
    }
}
