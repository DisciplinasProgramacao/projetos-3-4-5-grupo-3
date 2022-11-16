public class Gasto {
    private final String tipo;
    private final double valor;


    public Gasto(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    public String getTipo() {
        return tipo;
    }
}
