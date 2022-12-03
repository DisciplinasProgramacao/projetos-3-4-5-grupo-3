public interface IFabrica {
    /* Fábrica genérica que engloba a criação de um veiculo qualquer*/
    public Veiculo criar(double preco, String placa) throws Exception;
}
