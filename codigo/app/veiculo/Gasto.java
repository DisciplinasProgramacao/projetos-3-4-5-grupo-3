package app.veiculo;

public class Gasto {

    //region #Attributes
    private final String tipo;
    private final double valor;


    //Construtor passando o tipo do gasto e o valor
    public Gasto(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    //gregion #get
    public double getValor() {
        return this.valor;
    }

    public String getTipo() {
        return tipo;
    }
}
