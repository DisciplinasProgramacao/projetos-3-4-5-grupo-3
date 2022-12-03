package app.veiculo;

public enum Combustivel {

    /* área para parâmetro de cada combustível */
    GASOLINA("Gasolina", 12, 4.8),
    ETANOL("Etanol", 8, 3.65),
    DIESEL("Diesel", 3.5, 6.65);

    /* region #Attributes */
    private final double consumo;
    private final String nomeCombustivel;
    private final double preco;


    /*
     * Construtor da enum
     */
    Combustivel(String nomeCombustivel, double consumo, double preco) {
        this.nomeCombustivel = nomeCombustivel;
        this.consumo = consumo;
        this.preco = preco;
    }

    /* region #get */
    public double getConsumo() {
        return consumo;
    }

    public String getNomeCombustivel() {
        return nomeCombustivel;
    }

    public double getPreco() {
        return preco;
    }
}