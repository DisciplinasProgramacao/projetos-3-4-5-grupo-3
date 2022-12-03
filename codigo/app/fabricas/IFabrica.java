package app.fabricas;

import app.veiculo.Veiculo;

public interface IFabrica {
    /* Fábrica genérica que engloba a criação de um app.veiculo qualquer*/
    public Veiculo criar(double preco, String placa) throws Exception;
}
