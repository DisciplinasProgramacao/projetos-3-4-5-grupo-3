public abstract class Veiculo {
    protected double capacidadeTanque;
    protected double autonomiaDiaria;
    protected Rota rota;
    protected double quilometragremMedia;
    protected double ipva;
    protected double seguro;
    protected double kmPercorridos;

    protected abstract void calcularIpva();

    protected abstract void calcularSeguro();

    protected abstract void calcularOutrosCustos();

    public void incluirRota() {

    }

}
